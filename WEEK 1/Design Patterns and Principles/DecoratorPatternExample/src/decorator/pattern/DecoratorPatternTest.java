package decorator.pattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello World!");

        System.out.println();

        Notifier emailAndSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSmsNotifier.send("Hello World!");

        System.out.println();

        Notifier emailSmsAndSlackNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        emailSmsAndSlackNotifier.send("Hello World!");
    }
}
