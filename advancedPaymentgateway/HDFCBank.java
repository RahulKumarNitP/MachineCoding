package paymentgateway;

public class HDFCBank implements Bank {
    @Override
    public boolean processPayment(String paymentId, double amount) {
        // Implement HDFC bank payment processing logic
        return true; // Simulated success
    }
}