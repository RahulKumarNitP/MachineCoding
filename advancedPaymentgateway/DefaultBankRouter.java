package paymentgateway;

import java.util.Map;

public class DefaultBankRouter implements BankRouter {

    private final Map<PaymentMethod, Bank> bankMappings;

    public DefaultBankRouter(Map<PaymentMethod, Bank> bankMappings) {
        this.bankMappings = bankMappings;
    }

    @Override
    public Bank routeBank(PaymentMethod method) {
        return bankMappings.get(method);
    }
}