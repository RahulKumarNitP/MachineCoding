package FlipkartBiddingSystem.service;

import FlipkartBiddingSystem.model.User;

public interface Payment {
    public void makePayment(User user, double amount);
}
