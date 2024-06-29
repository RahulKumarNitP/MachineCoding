package RailwayPlatform;

class Ticket {
    private String passengerName;
    private Train train;
    private String seatNumber;

    public Ticket(String passengerName, Train train, String seatNumber) {
        this.passengerName = passengerName;
        this.train = train;
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Train getTrain() {
        return train;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
