package IncidentNotifier;

public class Incident {
    private String id;
    private String type;
    private String details;

    public Incident(String id, String type, String details) {
        this.id = id;
        this.type = type;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }
}
