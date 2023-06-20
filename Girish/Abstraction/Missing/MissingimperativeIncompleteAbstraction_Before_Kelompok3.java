import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.command.ApplicationCommandOption;
import discord4j.discordjson.json.ApplicationCommandOptionData;
import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.RestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public class Program {
    
    public static void main(String[] args) throws Exception {
        var token = Optional.ofNullable(System.getenv("TOKEN"))
                .orElseThrow(() -> new Exception("Bot token not found."));
        // You shouldn't need to change anything above this
        
        var slashCommandHandler = new SlashCommandHandler();

        // You shouldn't need to change anything below this
        DiscordClientBuilder.create(token)
                .build()
                .withGateway(gateway -> {
                    var printOnLogin = gateway.on(ReadyEvent.class, event -> Mono.fromRunnable(() -> {
                                var self = event.getSelf();
                                System.out.printf("Logged in as %s#%s%n", self.getUsername(), self.getDiscriminator());
                            }))
                            .then();

                    var handleSlash = gateway.on(ChatInputInteractionEvent.class, slashCommandHandler::handle)
                            .then();
                    
                    registerCommands(gateway.getRestClient());

                    return printOnLogin.and(handleSlash);
                })
                .block();
    }

    private static void registerCommands(RestClient client) {
        final var appId = client.getApplicationId()
                .block();
        if (appId == null) return;
        var qrCommandRequest = ApplicationCommandRequest.builder()
                .name("qr")
                .description("encode some text into a QR image")
                .addOption(ApplicationCommandOptionData.builder()
                        .name("text")
                        .description("text to encode")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .build();
        var qrSaveRequest = ApplicationCommandRequest.builder()
                .name("qrsave")
                .description("save a QR with a name")
                .addOption(ApplicationCommandOptionData.builder()
                        .name("text")
                        .description("text to encode")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .addOption(ApplicationCommandOptionData.builder()
                        .name("name")
                        .description("a unique name to save your QR")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .build();
        var qrLoadRequest = ApplicationCommandRequest.builder()
                .name("qrload")
                .description("load a saved QR")
                .addOption(ApplicationCommandOptionData.builder()
                        .name("name")
                        .description("the name of your saved QR")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .build();
        client.getApplicationService()
                .bulkOverwriteGlobalApplicationCommand(appId, List.of(qrCommandRequest, qrSaveRequest, qrLoadRequest))
                .subscribe();
    }
}


import java.util.HashMap;
import java.util.Map;

// class that acts as our data access layer
public class QrData {
    public Map<String, String> savedData = new HashMap<>();
    
    public void store(String name, String content) {
        savedData.put(name, content);
    }
}

import io.nayuki.qrcodegen.QrCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

public class QrToByteArrayInputStream {
    public QrToByteArrayInputStream() {
        
    }
    
    public Optional<ByteArrayInputStream> convert(QrCode qr, int scale, int border, String format) {
        // Handle invalid inputs
        if (qr == null) 
            throw new NullPointerException();
        if (scale <= 0 || border < 0) 
            throw new IllegalArgumentException("Value out of range");
        if (border > Integer.MAX_VALUE / 2 || qr.size + border * 2L > Integer.MAX_VALUE / scale)
            throw new IllegalArgumentException("Scale or border too large");
        // We only support PNG here
        if (!format.equals("png"))
            throw new IllegalArgumentException();
        BufferedImage img = new BufferedImage((qr.size + border * 2) * scale, (qr.size + border * 2) * scale, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                boolean color = qr.getModule(x / scale - border, y / scale - border);
                img.setRGB(x, y, color ? 0x000000 : 0xFFFFFF);
            }
        }
        // how we do this is take the image, write it into a byte array output stream, and then create a byte array input stream from it
        // idk how else to do it 💀
        
        final var os = new ByteArrayOutputStream();
        // writing the image can fail.
        try {
            ImageIO.write(img, format, os);
        } catch (IOException e) {
            return Optional.empty();
        }
        var result = new ByteArrayInputStream(os.toByteArray());
        return Optional.of(result);
    }
}

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import discord4j.core.spec.MessageCreateFields;
import io.nayuki.qrcodegen.QrCode;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class SlashCommandHandler {
    private static final int QR_SCALE = 4;
    private static final int QR_BORDER = 1;
    private final QrData qrData = new QrData();

    // "event" contains information about the slash command that was received.
    // we will be using this information to figure out what command was sent (convert text to qr, save a qr, load a qr)
    // and also get data from the command, like the text to convert. We call this data "Options".
    public Mono<Void> handle(ChatInputInteractionEvent event) {
        // we support three commands. They have the following names: ("qr", "qrsave" and "qrload")
        return switch (event.getCommandName()) {
            case "qr" -> handleEncode(event);
            case "qrsave" -> handleSave(event);
            case "qrload" -> handleLoad(event);
            default -> Mono.empty();
        };
    }

    // Command: qr
    // Options: text (text to turn into QR)
    private Mono<Void> handleEncode(ChatInputInteractionEvent event) {
        // retrieve the option called "text". It may not exist, so we get an Optional 
        // Optional is a native Java type representing "something or nothing". 
        // Not to be confused with "Option" which relates to the slash command.
        return event.getOption("text")
                // what we have so far: The Option called "text", or nothing.
                // try to get its value.
                // the option may not have a value, so this function (getValue) returns an Optional too.
                // thus, we use flatMap, or a "Bind" operation in FP terms.
                // basics of Bind/flatMap: 
                // takes a function F that takes in type A and returns type Optional<B>
                // Bind/flatMap converts Optional<A> into Optional<B>
                // if we have nothing(A), we don't apply the function, we end up with nothing(B).
                // if we have something(A), but the function returns nothing, we end up with nothing(B).
                // if we have something(A), and the function returns something, we end up with the new something(B).
                .flatMap(ApplicationCommandInteractionOption::getValue)
                // what we have so far: The value of the Option called "name", or nothing.
                // we take that value as a string
                // it is guaranteed to be interpretable as a string: so "asString" just returns a String
                // thus we use a normal Map operation
                // basics of Map:
                // takes a function F that takes in type A and returns type B
                // Map converts Optional<A> into Optional<B>
                // if we have nothing(A), we don't apply the function, we end up with nothing(B).
                // if we have something(A), apply the function, we end up with something(B)
                .map(ApplicationCommandInteractionOptionValue::asString)
                // what we have so far: The text to encode into QR, or nothing.
                .map(content -> QrCode.encodeText(content, QrCode.Ecc.LOW))
                // what we have so far: The text as a QR object, or nothing.
                // convert into image
                // this operation can fail. 
                // It returns an Optional.
                .flatMap(qr -> new QrToByteArrayInputStream().convert(qr, QR_SCALE, QR_BORDER, "png"))
                // what we have so far: A byte stream which is our QR image in PNG format, or nothing.
                // we now reply to the original slash command, and attach the image to our reply.
                // this operation returns a Mono<Void> (reactive stuff, not rlly important rn)
                .map(inputStream -> event.reply()
                        .withFiles(MessageCreateFields.File.of("QR.png", inputStream))
                        .then())
                // if we have nothing, then just return an empty Mono i.e. "this bot will do nothing"
                .orElse(Mono.empty());
    }

    // Command: qrsave
    // Options: text (text to save as QR), name (name to save the qr as, to refer to later)
    private Mono<Void> handleSave(ChatInputInteractionEvent event) {
        event.getOption("text")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                // what we have so far: The text to save, or nothing.
                // ifPresent will run the provided code if there is something
                .ifPresent(textToSave -> event.getOption("name")
                        .flatMap(ApplicationCommandInteractionOption::getValue)
                        .map(ApplicationCommandInteractionOptionValue::asString)
                        // what we have so far: 
                        // The text to save, as "textToSave".
                        // The name to save as, or nothing
                        .ifPresent(nameToSaveAs -> qrData.store(nameToSaveAs, textToSave)));
        
        // just reply to the slash command with "OK"
        // yes, it will reply "OK" even if the saving wasn't successful
        return event.reply()
                .withContent("OK")
                .then();
    }

    // Command: qrload
    // Options: name (name of the saved qr that was given when it was saved)
    private Mono<Void> handleLoad(ChatInputInteractionEvent event) {
        return event.getOption("name")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                // what we have so far: The name of the QR to load, or nothing.
                // we can now retrieve the saved QR using its name
                // we can't guarantee a QR with this name exists, so
                // the retrieval process gives us an Optional
                // thus we use flatMap again
                // BTW, we don't actually save the *QR*, we just save the text.
                // when it's requested, we just convert it back into QR.
                // simpler this way.
                .flatMap(name -> Optional.ofNullable(qrData.savedData.getOrDefault(name, null)))
                // what we have so far: The text to encode into QR, or nothing.
                // encode the saved text into QR
                .map(content -> QrCode.encodeText(content, QrCode.Ecc.LOW))
                .flatMap(qr -> new QrToByteArrayInputStream().convert(qr, QR_SCALE, QR_BORDER, "png"))
                .map(inputStream -> event.reply()
                        .withFiles(MessageCreateFields.File.of("QR.png", inputStream))
                        .then())
                .orElse(Mono.empty());
    }
}