package RailwayPlatform;

import java.util.ArrayList;
import java.util.List;

class BookingSystem {
    private List<Passenger> passengers;

    public BookingSystem() {
        this.passengers = new ArrayList<>();
    }

    public void bookTicket(String passengerName, Train train, String seatNumber) {
        Passenger passenger = findPassengerByName(passengerName);
        if (passenger == null) {
            passenger = new Passenger(passengerName);
            passengers.add(passenger);
        }
        Ticket ticket = new Ticket(passengerName, train, seatNumber);
        passenger.bookTicket(ticket);
    }

    private Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        return null;
    }
}
