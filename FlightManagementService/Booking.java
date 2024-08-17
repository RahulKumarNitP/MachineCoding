// Booking class representing a booking made by a passenger
class Booking {
    private String bookingId;
    private String passengerName;
    private Flight flight;
    private Fare fare;
    private Seat seat;

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