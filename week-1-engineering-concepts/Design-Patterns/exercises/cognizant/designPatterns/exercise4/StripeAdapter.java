package cognizant.designPatterns.exercise4;

public class StripeAdapter implements PaymentProcessor {

    private StripeGateway stripeGateway;

    public StripeAdapter() {
        stripeGateway = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }

}




