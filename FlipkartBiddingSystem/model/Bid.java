package FlipkartBiddingSystem.model;

public class Bid {
    private int bidId;
    private int itemId;
    private int bidderId;
    private double bidAmount;
    // Other bid attributes
    
    public Bid(int bidId, int itemId, int bidderId, double bidAmount) {
        this.bidId = bidId;
        this.itemId = itemId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;
    }
    
    // Getters and setters
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}