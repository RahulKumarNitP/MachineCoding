package newPaymentGateway;

import java.util.HashMap;
import java.util.Map;

public class DefaultBankRouter implements BankRouter {

    private final Map<PaymentMethod, Bank> bankMappings;

    public DefaultBankRouter() {
        // Initialize bank mappings
        this.bankMappings = new HashMap<>();
        this.bankMappings.put(PaymentMethod.UPI, new HDFCBank());
        this.bankMappings.put(PaymentMethod.CREDIT_CARD, new HDFCBank());
        this.bankMappings.put(PaymentMethod.DEBIT_CARD, new ICICIBank());
        this.bankMappings.put(PaymentMethod.NET_BANKING, new ICICIBank());
    }

    @Override
    public Bank routeBank(PaymentMethod method) {
        return bankMappings.get(method);
    }
}