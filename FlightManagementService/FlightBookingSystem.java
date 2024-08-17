import java.util.List;

public class FlightBookingSystem {
    public static void main(String[] args) {
        // Create a list of available flights
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("F001", "New York", "London", "2024-04-10 10:00", 480));
        flights.add(new Flight("F002", "London", "Paris", "2024-04-11 12:00", 180));
        flights.add(new Flight("F003", "New York", "Paris", "2024-04-12 14:00", 540));

        // Search for flights from New York to Paris on 2024-04-12
        String origin = "New York";
        String destination = "Paris";
        String departureDate = "2024-04-12";
        
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
