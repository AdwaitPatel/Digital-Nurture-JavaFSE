package cognizant.designPatterns.exercise4;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter();
        PaymentProcessor stripe = new StripeAdapter();
        PaymentProcessor razorpay = new RazorpayAdapter();

        paypal.processPayment(1000);
        stripe.processPayment(2500);
        razorpay.processPayment(5000);

    }
}