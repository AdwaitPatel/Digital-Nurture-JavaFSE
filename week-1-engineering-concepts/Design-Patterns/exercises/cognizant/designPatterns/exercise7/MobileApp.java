package cognizant.designPatterns.exercise7;

public class MobileApp implements Observer {

    @Override
    public void update(String stockName, double price) {
        System.out.println("mobile app : " + stockName + " price updated to ₹" + price);
    }
}


