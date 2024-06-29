package RailwayPlatform;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Station {
    private List<Platform> platforms;
    private List<Schedule> schedules;
    private List<Train> waitingTrains;

    public Station() {
        this.platforms = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.waitingTrains = new ArrayList<>();
    }

    public void addPlatform(Platform platform) {
        platforms.add(platform);
    }

    public boolean addSchedule(Schedule schedule) {
        for (Schedule existingSchedule : schedules) {
            if (schedule.conflictsWith(existingSchedule)) {
                System.out.println("Schedule conflict detected for platform " + schedule.getPlatform().getPlatformNumber());
                return false; // Conflict found
            }
        }
        schedules.add(schedule);
        schedule.getPlatform().getTrains().add(schedule.getTrain());
        schedule.getTrain().getSchedule().add(schedule);
        return true;
    }

    public void registerWaitingTrain(Train train) {
        waitingTrains.add(train);
    }

    public void notifyTrainsOfAvailablePlatform() {
        for (Platform platform : platforms) {
            if (platform.isAvailable(LocalTime.now())) {
                for (Train train : waitingTrains) {
                    train.notifyPlatformAvailable(platform);
                }
                waitingTrains.clear();
                break;
            }
        }
    }
}
