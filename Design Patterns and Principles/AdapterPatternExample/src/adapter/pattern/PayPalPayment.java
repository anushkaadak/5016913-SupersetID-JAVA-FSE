package adapter.pattern;

public class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
