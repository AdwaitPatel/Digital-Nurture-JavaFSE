package cognizant.designPatterns.exercise6;

public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("image.jpg");

        System.out.println("first display:");
        image.display();
        System.out.println("second and third display:");
        image.display();
        image.display();

    }
}



