package FlightManagementService;

import java.util.ArrayList;
import java.util.List;

public class FlightBookingSystem {
    public static void main(String[] args) {
        // Create a list of available flights
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight("F001", "New York", "London", "2024-04-10 10:00", 480);
        flight1.addFare("Economy", 500.0);
        flight1.addFare("Business", 1500.0);
        flights.add(flight1);
        Flight flight2 = new Flight("F002", "London", "Paris", "2024-04-11 12:00", 180);
        flight2.addFare("Economy", 500.0);
        flight2.addFare("Business", 1500.0);
        flights.add(flight2);
        // Check availability and make a booking
        String selectedFareType = "Economy";
        if (flight1.checkAvailability(selectedFareType)) {
            Fare selectedFare = null;
            for (Fare fare : flight1.getFares()) {
                if (fare.getFareType().equals(selectedFareType)) {
                    selectedFare = fare;
                    break;
                }
            }

            if (selectedFare != null && selectedFare.isAvailable()) {
                Seat availableSeat = new Seat("A1", selectedFareType);
                Booking booking = new Booking("B001", "John Doe", flight1, selectedFare, availableSeat);

                System.out.println("Booking successful for " + booking.getPassengerName() +
                        " on flight " + flight1.getFlightId() +
                        " with seat " + availableSeat.getSeatNumber());
            } else {
                System.out.println("Selected fare type is not available.");
            }
        } else {
            System.out.println("Selected fare type is not available.");
        }

        // Search for flights from New York to Paris on 2024-04-12
        String origin = "New York";
        String destination = "London";
        String departureDate = "2024-04-10";

        List<Flight> searchResults = Flight.searchFlights(flights, origin, destination, departureDate);

        // Display search results
        if (searchResults.isEmpty()) {
            System.out.println("No flights found matching the search criteria.");
        } else {
            System.out.println("Flights found:");
            for (Flight flight : searchResults) {
                System.out.println("Flight ID: " + flight.getFlightId() +
                        ", Origin: " + flight.getOrigin() +
                        ", Destination: " + flight.getDestination() +
                        ", Departure Time: " + flight.getDepartureTime());
            }
        }
    }
}
