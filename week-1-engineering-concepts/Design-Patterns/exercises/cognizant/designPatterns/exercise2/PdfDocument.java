package cognizant.designPatterns.exercise2;

public class PdfDocument implements Document{

    @Override
    public void open() {
        System.out.println("PDF Document is opened");
    }

}
