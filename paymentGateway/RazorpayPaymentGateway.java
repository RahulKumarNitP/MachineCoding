package newPaymentGateway;

import java.util.*;

public class RazorpayPaymentGateway {

    private final BankRouter bankRouter;
    private final Map<String, List<PaymentMethod>> clientSupportedMethods = new HashMap<>();

    public RazorpayPaymentGateway(BankRouter bankRouter) {
        this.bankRouter = bankRouter;
    }

    public String initiatePayment(double amount, PaymentMethod method, String clientId) {
        Bank selectedBank = bankRouter.routeBank(method);
        if (selectedBank == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }

        // Simulate payment initiation
        String paymentId = generatePaymentId();
        boolean success = selectedBank.processPayment(paymentId, amount);

        handlePaymentCallback(paymentId, success);
        return paymentId;
    }

    public void onboardClient(String clientId, List<PaymentMethod> supportedMethods) {
        clientSupportedMethods.put(clientId, supportedMethods);
    }

    public List<PaymentMethod> getSupportedPaymentMethods(String clientId) {
        return clientSupportedMethods.getOrDefault(clientId, Arrays.asList());
    }

    private String generatePaymentId() {
        return "PAY-" + System.currentTimeMillis();
    }

    private void handlePaymentCallback(String paymentId, boolean status) {
        System.out.println("Payment callback received for payment ID: " + paymentId + " with status: " + status);
    }

    public static void main(String[] args) {
        // Create payment gateway with DefaultBankRouter
        BankRouter bankRouter = new DefaultBankRouter();
        RazorpayPaymentGateway paymentGateway = new RazorpayPaymentGateway(bankRouter);

        // Onboard clients with supported payment methods
        paymentGateway.onboardClient("Client1", Arrays.asList(PaymentMethod.UPI, PaymentMethod.DEBIT_CARD));
        paymentGateway.onboardClient("Client2", Arrays.asList(PaymentMethod.CREDIT_CARD, PaymentMethod.NET_BANKING));

        // Simulate initiating payments for onboarded clients
        String upiPaymentId = paymentGateway.initiatePayment(500.0, PaymentMethod.UPI, "Client1");
        String creditCardPaymentId = paymentGateway.initiatePayment(1000.0, PaymentMethod.CREDIT_CARD, "Client2");

        // Query supported payment methods for clients
        List<PaymentMethod> client1Methods = paymentGateway.getSupportedPaymentMethods("Client1");
        List<PaymentMethod> client2Methods = paymentGateway.getSupportedPaymentMethods("Client2");

        System.out.println("Supported payment methods for Client1: " + client1Methods);
        System.out.println("Supported payment methods for Client2: " + client2Methods);
    }
}
