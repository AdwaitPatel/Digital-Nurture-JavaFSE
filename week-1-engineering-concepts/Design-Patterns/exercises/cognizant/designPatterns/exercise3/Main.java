package cognizant.designPatterns.exercise3;

public class Main {
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32 GB")
                .setStorage("1 TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("16 GB")
                .setStorage("512 GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC");
        gamingPC.displayConfiguration();

        System.out.println();

        System.out.println("Office PC");
        officePC.displayConfiguration();

    }
}
