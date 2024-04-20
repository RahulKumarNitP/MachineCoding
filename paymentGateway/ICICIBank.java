package newPaymentGateway;

public class ICICIBank implements Bank {
    @Override
    public boolean processPayment(String paymentId, double amount) {
        // Simulate ICICI bank payment processing logic
        System.out.println("Processing payment with ICICI Bank");
        return true; // Simulated success
    }
}