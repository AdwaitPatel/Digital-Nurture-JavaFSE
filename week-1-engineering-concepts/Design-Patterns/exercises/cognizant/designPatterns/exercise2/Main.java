package cognizant.designPatterns.exercise2;

public class Main {
    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();

        pdfDocument.open();
        wordDocument.open();
        excelDocument.open();
    }
}



