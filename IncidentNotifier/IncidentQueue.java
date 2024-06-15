package IncidentNotifier;

import java.util.Queue;
import java.util.LinkedList;

import java.util.Queue;
import java.util.LinkedList;

public class IncidentQueue {
    private Queue<Incident> incidents = new LinkedList<>();

    public void addIncident(Incident incident) {
        incidents.add(incident);
    }

    public void processIncidents(Notifier notifier) {
        while (!incidents.isEmpty()) {
            Incident incident = incidents.peek();
            notifier.notify(incident);
        }
    }
}

