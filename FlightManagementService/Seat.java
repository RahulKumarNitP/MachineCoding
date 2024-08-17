// Seat class representing a seat in a flight
class Seat {
    private String seatNumber;
    private String fareType;
    private boolean booked;

    public Seat(String seatNumber, String fareType) {
        this.seatNumber = seatNumber;
        this.fareType = fareType;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void bookSeat() {
        this.booked = true;
    }
}