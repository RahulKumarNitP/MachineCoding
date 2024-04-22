package FlipkartBiddingSystem.model;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private double startingBid;
    private double currentBid;
    private int sellerId;
    // Other item attributes
    
    public Item(int itemId, String itemName, String description, double startingBid, int sellerId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.startingBid = startingBid;
        this.currentBid = startingBid;
        this.sellerId = sellerId;
    }
    
    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}