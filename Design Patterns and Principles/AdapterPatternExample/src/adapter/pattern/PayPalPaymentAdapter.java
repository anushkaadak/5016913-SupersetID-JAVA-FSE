package adapter.pattern;

public class PayPalPaymentAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalPaymentAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.makePayment(amount);
    }
}

