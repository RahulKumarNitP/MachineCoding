package newPaymentGateway;

public interface BankRouter {
    Bank routeBank(PaymentMethod method);
}