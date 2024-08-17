import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private String departureTime;
    private int duration;
    private List<Fare> fares;

    public Flight(String flightId, String origin, String destination, String departureTime, int duration) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.duration = duration;
        this.fares = new ArrayList<>();
    }

    public void addFare(String fareType, double price) {
        Fare fare = new Fare(fareType, price);
        fares.add(fare);
    }

    public boolean checkAvailability(String fareType) {
        for (Fare fare : fares) {
            if (fare.getFareType().equals(fareType) && fare.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<Fare> getFares() {
        return fares;
    }

    // Method to search for flights based on origin, destination, and departure date
    public static List<Flight> searchFlights(List<Flight> flights, String origin, String destination, String departureDate) {
        List<Flight> searchResults = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) &&
                flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getDepartureTime().startsWith(departureDate)) {
                searchResults.add(flight);
            }
        }
        return searchResults;
    }
}
