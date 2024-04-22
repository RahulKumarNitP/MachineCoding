package FlipkartBiddingSystem.service;

import FlipkartBiddingSystem.model.User;

public class DefaultPayment implements Payment {
    @Override
    public void makePayment(User user, double amount) {
        System.out.println("Payment of $" + amount + " made by user " + user.getUserId());
    }
}
