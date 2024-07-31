package adapter.pattern;

public class SquarePaymentAdapter implements PaymentProcessor {
    private SquarePayment squarePayment;

    public SquarePaymentAdapter(SquarePayment squarePayment) {
        this.squarePayment = squarePayment;
    }

    @Override
    public void processPayment(double amount) {
        squarePayment.performPayment(amount);
    }
}
