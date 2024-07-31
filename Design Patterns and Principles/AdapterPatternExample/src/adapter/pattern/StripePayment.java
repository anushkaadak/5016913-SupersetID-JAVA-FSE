package adapter.pattern;

public class StripePayment {
    public void executePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
