package FlightManagementService;

// Seat class representing a seat in a flight
class Seat {
    private String seatNumber;
    private String fareType;
    private boolean booked;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

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