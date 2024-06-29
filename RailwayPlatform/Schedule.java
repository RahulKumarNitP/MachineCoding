package RailwayPlatform;

import java.time.LocalTime;

class Schedule {
    private Train train;
    private Platform platform;
    private LocalTime arrivalTime;
    private LocalTime departureTime;

    public Schedule(Train train, Platform platform, LocalTime arrivalTime, LocalTime departureTime) {
        this.train = train;
        this.platform = platform;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Train getTrain() {
        return train;
    }

    public Platform getPlatform() {
        return platform;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public boolean conflictsWith(Schedule other) {
        return this.platform == other.platform && 
               (this.arrivalTime.isBefore(other.departureTime) && other.arrivalTime.isBefore(this.departureTime));
    }
}
