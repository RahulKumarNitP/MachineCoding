package RailwayPlatform;

import java.util.ArrayList;
import java.util.List;

class Passenger {
    private String name;
    private List<Ticket> tickets;

    public Passenger(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void bookTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
