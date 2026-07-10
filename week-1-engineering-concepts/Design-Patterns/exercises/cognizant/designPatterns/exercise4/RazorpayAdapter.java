package cognizant.designPatterns.exercise4;

public class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway razorpayGateway;

    public RazorpayAdapter() {
        razorpayGateway = new RazorpayGateway();
    }

    @Override
    public void processPayment(double amount) {
        razorpayGateway.payNow(amount);
    }

}



