package newPaymentGateway;

public class HDFCBank implements Bank {
    @Override
    public boolean processPayment(String paymentId, double amount) {
        // Simulate HDFC bank payment processing logic
        System.out.println("Processing payment with HDFC Bank");
        return true; // Simulated success
    }
}