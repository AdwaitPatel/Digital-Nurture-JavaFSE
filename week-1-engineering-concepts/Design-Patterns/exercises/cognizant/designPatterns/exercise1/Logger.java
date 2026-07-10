package cognizant.designPatterns.exercise1;

public class Logger {
    private static Logger logger = null;

    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
            System.out.println("New object created");
        }
        return logger;
    }
}





