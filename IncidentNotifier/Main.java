package IncidentNotifier;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IncidentQueue incidentQueue = new IncidentQueue();
        Notifier notifier = new Notifier(Arrays.asList(new EmailChannel(), new SMSChannel()));
        IncidentDetector detector = new IncidentDetector(incidentQueue);

        detector.detect();
        incidentQueue.processIncidents(notifier);
    }
}
