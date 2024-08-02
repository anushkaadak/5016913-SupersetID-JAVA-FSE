package strategy.pattern;

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.pay(250.00);

        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.pay(150.00);
    }
}
