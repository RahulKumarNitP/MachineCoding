package IncidentNotifier;

import java.util.UUID;

public class IncidentDetector {
    private IncidentQueue incidentQueue;

    public IncidentDetector(IncidentQueue incidentQueue) {
        this.incidentQueue = incidentQueue;
    }

    public void detect() {
        // Simulate incident detection
        String id = UUID.randomUUID().toString();
        Incident incident = new Incident(id, "Error", "An error occurred in the system");
        incidentQueue.addIncident(incident);
    }
}
