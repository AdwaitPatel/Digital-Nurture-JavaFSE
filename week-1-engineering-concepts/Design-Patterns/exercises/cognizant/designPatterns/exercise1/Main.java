package cognizant.designPatterns.exercise1;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        // test -> if true -> only one obj created
        System.out.println((logger1 == logger2) && (logger1 == logger3));

    }
}





