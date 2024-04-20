package paymentgateway;

public interface BankRouter {
    Bank routeBank(PaymentMethod method);
}
