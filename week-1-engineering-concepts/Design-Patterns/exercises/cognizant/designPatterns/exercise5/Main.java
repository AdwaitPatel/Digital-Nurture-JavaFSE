package cognizant.designPatterns.exercise5;

public class Main {
    public static void main(String[] args) {

        Notifier notifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );

        notifier.send("server is down!");

    }
}



