package FlipkartBiddingSystem;

import FlipkartBiddingSystem.model.Bid;
import FlipkartBiddingSystem.model.Item;
import FlipkartBiddingSystem.model.NotificationDao;
import FlipkartBiddingSystem.model.User;
import FlipkartBiddingSystem.service.BiddingService;

public class Runner {
    public static void main(String[] args) {
        BiddingService biddingService = new BiddingService();

        // Register users
        User user1 = new User(1, "Rahul", "rahul@example.com");
        User user2 = new User(2, "Rama", "rama@example.com");
        biddingService.registerUser(user1);
        biddingService.registerUser(user2);

        // Add items
        Item item1 = new Item(101, "Mac book", "Brand new macbook", 1500.0, 1);
        Item item2 = new Item(102, "Bike", "High-performance bike", 1200.0, 2);
        biddingService.addItem(item1);
        biddingService.addItem(item2);

        // Place bids
        Bid bid1 = new Bid(1, 101, 2, 1550.0);
        Bid bid2 = new Bid(2, 102, 1, 1250.0);
        biddingService.placeBid(bid1);
        biddingService.placeBid(bid2);

        // Calculate winners
        User winner1 = biddingService.calculateWinner(101);
        User winner2 = biddingService.calculateWinner(102);
        if (winner1 != null) {
            System.out.println("Winner for item 101: " + winner1.getUsername());
            biddingService.sendNotification(new NotificationDao(1, winner1.getUserId(), "Congratulations! You won the auction for the smartphone."));
            biddingService.makePayment(winner1, item1.getCurrentBid());
        }
        if (winner2 != null) {
            System.out.println("Winner for item 102: " + winner2.getUsername());
            biddingService.sendNotification(new NotificationDao(2, winner2.getUserId(), "Congratulations! You won the auction for the laptop."));
            biddingService.makePayment(winner2, item2.getCurrentBid());
        }
    }
}
