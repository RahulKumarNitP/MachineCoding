package newPaymentGateway;

public interface Bank {
    boolean processPayment(String paymentId, double amount);
}