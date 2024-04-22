package FlipkartBiddingSystem.service;

import FlipkartBiddingSystem.model.NotificationDao;
import FlipkartBiddingSystem.model.Bid;
import FlipkartBiddingSystem.model.Item;
import FlipkartBiddingSystem.model.User;

import java.util.ArrayList;
import java.util.List;

// Bidding System class
public class BiddingService {
    private List<User> users;
    private List<Item> items;
    private List<Bid> bids;
    private List<NotificationDao> notificationDaos;
    // In real use-case, use some dependency injection framework like Spring, Guice etc.
    private Notification defaultNotification;
    private Payment defaultPayment;
    
    public BiddingService() {
        users = new ArrayList<>();
        items = new ArrayList<>();
        bids = new ArrayList<>();
        notificationDaos = new ArrayList<>();
        defaultNotification = new DefaultNotification();
        defaultPayment = new DefaultPayment();
    }
    
    // Methods for user management
    public void registerUser(User user) {
        users.add(user);
    }
    
    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
    
    // Methods for item management
    public void addItem(Item item) {
        items.add(item);
    }
    
    public Item getItemById(int itemId) {
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }
    
    // Methods for bidding process
    public void placeBid(Bid bid) {
        bids.add(bid);
        // Update current bid of the item
        Item item = getItemById(bid.getItemId());
        if (item != null && bid.getBidAmount() > item.getCurrentBid()) {
            item.setCurrentBid(bid.getBidAmount());
            // Notify bidder
            User bidder = getUserById(bid.getBidderId());
            if (bidder != null) {
                NotificationDao notificationDao = new NotificationDao(notificationDaos.size() + 1, bidder.getUserId(), "Your bid was successful for item: " + item.getItemName());
                notificationDaos.add(notificationDao);
            }
        }
    }
    
    // Method to calculate the winner for a given item
    public User calculateWinner(int itemId) {
        Item item = getItemById(itemId);
        if (item != null) {
            double maxBid = item.getStartingBid();
            User winner = null;
            for (Bid bid : bids) {
                if (bid.getItemId() == itemId && bid.getBidAmount() > maxBid) {
                    maxBid = bid.getBidAmount();
                    winner = getUserById(bid.getBidderId());
                }
            }
            return winner;
        }
        return null;
    }
    
    // Method to send notification to a user
    public void sendNotification(NotificationDao notificationDao) {
        notificationDaos.add(notificationDao);
        // You can implement the notification mechanism here (e.g., email, SMS, push notification)
        defaultNotification.sendNotification(notificationDao);
    }
    
    // Method to simulate payment integration
    public void makePayment(User user, double amount) {
        // Implementation of payment integration (e.g., deducting amount from user's account)
        defaultPayment.makePayment(user, amount);
    }
}
