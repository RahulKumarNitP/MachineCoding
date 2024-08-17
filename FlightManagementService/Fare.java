// Fare class representing a fare type for a flight
class Fare {
    private String fareType;
    private double price;
    private boolean available;

    public Fare(String fareType, double price) {
        this.fareType = fareType;
        this.price = price;
        this.available = true;
    }

    public String getFareType() {
        return fareType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}