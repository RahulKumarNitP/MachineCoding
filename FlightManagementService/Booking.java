package FlightManagementService;

// Booking class representing a booking made by a passenger
class Booking {
    private String bookingId;
    private String passengerName;
    private Flight flight;
    private Fare fare;
    private Seat seat;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Booking(String bookingId, String passengerName, Flight flight, Fare fare, Seat seat) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.fare = fare;
        this.seat = seat;
        this.seat.bookSeat(); // Mark the seat as booked upon creating a booking
    }

    public void cancelBooking() {
        this.seat = null; // Free up the seat upon cancellation
    }
}