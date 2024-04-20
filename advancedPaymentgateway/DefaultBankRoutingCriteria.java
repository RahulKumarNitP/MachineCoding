package paymentgateway;

import java.util.Map;

public class DefaultBankRoutingCriteria implements BankRoutingCriteria {

    private final Map<PaymentMethod, Bank> methodToBankMapping;

    public DefaultBankRoutingCriteria(Map<PaymentMethod, Bank> methodToBankMapping) {
        this.methodToBankMapping = methodToBankMapping;
    }

    @Override
    public Bank selectBank(PaymentMethod method) {
        return methodToBankMapping.get(method);
    }
}