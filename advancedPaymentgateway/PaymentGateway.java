package paymentgateway;

import java.util.List;
import java.util.Map;

public interface PaymentGateway {
    String initiatePayment(double amount, String clientId, PaymentMethod method);
    boolean processPayment(String paymentId, double amount, String clientId);
    void handlePaymentCallback(String paymentId, boolean status);
    void registerClient(String clientId, List<PaymentMethod> supportedMethods);
    void setBankRoutingCriteria(BankRoutingCriteria criteria);
    void setBankTrafficAllocation(Map<String, Double> bankAllocation);
}




