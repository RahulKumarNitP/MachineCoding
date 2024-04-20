package paymentgateway;

public class ICICIBank implements Bank {
    @Override
    public boolean processPayment(String paymentId, double amount) {
        // Implement ICICI bank payment processing logic
        return true; // Simulated success
    }
}