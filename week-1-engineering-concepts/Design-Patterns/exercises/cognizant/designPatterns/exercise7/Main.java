package cognizant.designPatterns.exercise7;

public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStock("Cognizant", 4200);
        System.out.println();
        stockMarket.setStock("Cognizant", 4300);

    }
}