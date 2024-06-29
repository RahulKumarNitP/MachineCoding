package RailwayPlatform;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Platform {
    private int platformNumber;
    private List<Train> trains;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.trains = new ArrayList<>();
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public boolean isAvailable(LocalTime time) {
        for (Train train : trains) {
            for (Schedule schedule : train.getSchedule()) {
                if (schedule.getPlatform() == this &&
                    (time.isAfter(schedule.getArrivalTime()) && time.isBefore(schedule.getDepartureTime()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
