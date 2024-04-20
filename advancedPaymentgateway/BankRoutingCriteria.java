package paymentgateway;


public interface BankRoutingCriteria {
    Bank selectBank(PaymentMethod method);
}