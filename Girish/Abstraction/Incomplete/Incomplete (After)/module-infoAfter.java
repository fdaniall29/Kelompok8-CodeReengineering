module Incomplete {
    import com.example.EmailService;

    public class EmailService {
        public void sendEmail(String to, String subject, String body) {
            System.out.println("Sending email to: " + to);
            System.out.println("Subject: " + subject);
            System.out.println("Body: " + body);
            System.out.println("Email sent successfully!");
        }
    }

    public class Main {
        public static void main(String[] args) {
            EmailService emailService = new EmailService();
            emailService.sendEmail("john.doe@example.com", "Hello", "This is a test email.");
        }
    }
}
