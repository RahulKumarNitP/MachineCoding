package IncidentNotifier;

public class Notification {
    private String id;
    private String incidentId;
    private String message;

    public Notification(String id, String incidentId, String message) {
        this.id = id;
        this.incidentId = incidentId;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public String getMessage() {
        return message;
    }
}
