package cognizant.designPatterns.exercise4;

public class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter() {
        payPalGateway = new PayPalGateway();
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }

}




