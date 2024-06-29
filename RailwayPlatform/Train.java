package RailwayPlatform;

import java.util.ArrayList;
import java.util.List;

class Train {
    private String trainNumber;
    private String trainName;
    private List<Schedule> schedule;

    public Train(String trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.schedule = new ArrayList<>();
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void notifyPlatformAvailable(Platform platform) {
        System.out.println("Train " + trainName + " notified that platform " + platform.getPlatformNumber() + " is available.");
        // Logic to handle the notification
    }
}
