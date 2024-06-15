package IncidentNotifier;

import java.util.List;

import java.util.List;

public class Notifier {
    private List<NotificationChannel> channels;

    public Notifier(List<NotificationChannel> channels) {
        this.channels = channels;
    }

    public void notify(Incident incident) {
        for (NotificationChannel channel : channels) {
            channel.sendNotification(incident);
        }
    }
}
