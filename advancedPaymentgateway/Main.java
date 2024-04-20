package paymentgateway;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RazorpayPaymentGateway paymentGateway = new RazorpayPaymentGateway();

        // Configure bank mappings
        Map<PaymentMethod, Bank> bankMappings = new HashMap<>();
        bankMappings.put(PaymentMethod.UPI, new HDFCBank());
        bankMappings.put(PaymentMethod.CREDIT_CARD, new HDFCBank());
        bankMappings.put(PaymentMethod.DEBIT_CARD, new ICICIBank());
        bankMappings.put(PaymentMethod.NET_BANKING, new ICICIBank());

        BankRouter bankRouter = new DefaultBankRouter(bankMappings);
        BankRoutingCriteria bankRoutingCriteria = new DefaultBankRoutingCriteria(bankMappings);

        paymentGateway.setBankRouter(bankRouter);
        paymentGateway.setBankRoutingCriteria(bankRoutingCriteria);

        // Register clients
        paymentGateway.registerClient("Client1", Arrays.asList(PaymentMethod.UPI, PaymentMethod.DEBIT_CARD));
        paymentGateway.registerClient("Client2", Arrays.asList(PaymentMethod.CREDIT_CARD, PaymentMethod.NET_BANKING));

        // Initiate payments
        String paymentId1 = paymentGateway.initiatePayment(100.0, "Client1", PaymentMethod.UPI);
        String paymentId2 = paymentGateway.initiatePayment(200.0, "Client2", PaymentMethod.NET_BANKING);

        // Simulate processing payments
        paymentGateway.processPayment(paymentId1, 100.0, "Client1");
        paymentGateway.processPayment(paymentId2, 200.0, "Client2");
    }
}
