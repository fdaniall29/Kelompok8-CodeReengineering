import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
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
        
        var slashCommandHandler = new SlashCommandHandler(new QrData(), new QrCodeConverterImpl());

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
        final var appId = client.getApplicationId().block();
        if (appId == null) return;
        
        var qrCommandRequest = createCommandRequest("qr", "encode some text into a QR image",
                createOption("text", "text to encode", ApplicationCommandOption.Type.STRING.getValue(), true));
        
        var qrSaveRequest = createCommandRequest("qrsave", "save a QR with a name",
                createOption("text", "text to encode", ApplicationCommandOption.Type.STRING.getValue(), true),
                createOption("name", "a unique name to save your QR", ApplicationCommandOption.Type.STRING.getValue(), true));
        
        var qrLoadRequest = createCommandRequest("qrload", "load a saved QR",
                createOption("name", "the name of your saved QR", ApplicationCommandOption.Type.STRING.getValue(), true));
        
        client.getApplicationService()
                .bulkOverwriteGlobalApplicationCommand(appId, List.of(qrCommandRequest, qrSaveRequest, qrLoadRequest))
                .subscribe();
    }
    
    private static ApplicationCommandRequest createCommandRequest(String name, String description, ApplicationCommandOptionData... options) {
        return ApplicationCommandRequest.builder()
                .name(name)
                .description(description)
                .addAllOptions(List.of(options))
                .build();
    }
    
    private static ApplicationCommandOptionData createOption(String name, String description, int type, boolean required) {
        return ApplicationCommandOptionData.builder()
                .name(name)
                .description(description)
                .type(type)
                .required(required)
                .build();
    }
}


public class QrData {
    private final Map<String, String> savedData = new HashMap<>();
    
    public void storeQr(String name, String content) {
        savedData.put(name, content);
    }
    
    public Optional<String> getQr(String name) {
        return Optional.ofNullable(savedData.get(name));
    }
}


public interface QrCodeConverter {
    Optional<ByteArrayInputStream> convert(String text, int scale, int border, String format);
}


public class QrCodeConverterImpl implements QrCodeConverter {
    @Override
    public Optional<ByteArrayInputStream> convert(String text, int scale, int border, String format) {
        // Conversion logic here
        // ...
    }
}


public class SlashCommandHandler {
    private final QrData qrData;
    private final QrCodeConverter qrCodeConverter;

    public SlashCommandHandler(QrData qrData, QrCodeConverter qrCodeConverter) {
        this.qrData = qrData;
        this.qrCodeConverter = qrCodeConverter;
    }

    public Mono<?> handle(ChatInputInteractionEvent event) {
        var commandName = event.getCommandName();

        switch (commandName) {
            case "qr":
                return handleEncode(event);
            case "qrsave":
                return handleSave(event);
            case "qrload":
                return handleLoad(event);
            default:
                return Mono.empty();
        }
    }

    private Mono<?> handleEncode(ChatInputInteractionEvent event) {
        var option = event.getOption("text");
        var text = option.flatMap(ApplicationCommandInteractionOptionValue::asString).orElse("");

        var qrCodeResult = qrCodeConverter.convert(text, 300, 10, "png");
        if (qrCodeResult.isPresent()) {
            var qrStream = qrCodeResult.get();
            // Send the QR code as a response
            return event.replyWithFile(qrStream, "qr.png");
        } else {
            return event.reply("Failed to generate QR code.");
        }
    }

    private Mono<?> handleSave(ChatInputInteractionEvent event) {
        var textOption = event.getOption("text");
        var nameOption = event.getOption("name");
        
        var text = textOption.flatMap(ApplicationCommandInteractionOptionValue::asString).orElse("");
        var name = nameOption.flatMap(ApplicationCommandInteractionOptionValue::asString).orElse("");
        
        qrData.storeQr(name, text);
        
        return event.reply(String.format("QR saved with name '%s'", name));
    }

    private Mono<?> handleLoad(ChatInputInteractionEvent event) {
        var nameOption = event.getOption("name");
        
        var name = nameOption.flatMap(ApplicationCommandInteractionOptionValue::asString).orElse("");
        
        var qrResult = qrData.getQr(name);
        
        return qrResult.map(qrText -> {
            var qrCodeResult = qrCodeConverter.convert(qrText, 300, 10, "png");
            if (qrCodeResult.isPresent()) {
                var qrStream = qrCodeResult.get();
                // Send the QR code as a response
                return event.replyWithFile(qrStream, "qr.png");
            } else {
                return event.reply("Failed to generate QR code.");
            }
        }).orElseGet(() -> event.reply(String.format("QR with name '%s' not found.", name)));
    }
}
