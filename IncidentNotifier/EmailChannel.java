package IncidentNotifier;

public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(Incident incident) {
        System.out.println("Sending email notification for incident: " + incident.getId() + " - " + incident.getDetails());
    }
}

