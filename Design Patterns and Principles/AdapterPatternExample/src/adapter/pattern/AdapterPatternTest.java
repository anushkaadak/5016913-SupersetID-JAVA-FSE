package adapter.pattern;

public class AdapterPatternTest {
    public static void main(String[] args) {

        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentProcessor payPalProcessor = new PayPalPaymentAdapter(payPalPayment);
        payPalProcessor.processPayment(100.0);

        StripePayment stripePayment = new StripePayment();
        PaymentProcessor stripeProcessor = new StripePaymentAdapter(stripePayment);
        stripeProcessor.processPayment(200.0);

        SquarePayment squarePayment = new SquarePayment();
        PaymentProcessor squareProcessor = new SquarePaymentAdapter(squarePayment);
        squareProcessor.processPayment(300.0);
    }
}
