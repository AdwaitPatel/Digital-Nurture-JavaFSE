package cognizant.designPatterns.exercise8;

public class Main {
    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
        paymentContext.executePayment(2500);

        paymentContext = new PaymentContext(new PayPalPayment());
        paymentContext.executePayment(1500);






    }
}



