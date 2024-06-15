package IncidentNotifier;

public class SMSChannel implements NotificationChannel {
    @Override
    public void sendNotification(Incident incident) {
        System.out.println("Sending SMS notification for incident: " + incident.getId() + " - " + incident.getDetails());
    }
}
