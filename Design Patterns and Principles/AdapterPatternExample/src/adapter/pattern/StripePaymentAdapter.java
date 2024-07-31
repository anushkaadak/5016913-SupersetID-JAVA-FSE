package adapter.pattern;

public class StripePaymentAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripePaymentAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.executePayment(amount);
    }
}
