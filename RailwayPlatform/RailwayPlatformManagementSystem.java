package RailwayPlatform;

import java.time.LocalTime;

public class RailwayPlatformManagementSystem {
    public static void main(String[] args) {
        // Create station object
        Station station = new Station();

        // Create platforms object
        Platform platform1 = new Platform(1);
        Platform platform2 = new Platform(2);
        station.addPlatform(platform1);
        station.addPlatform(platform2);

        // Create trains object
        Train train1 = new Train("123", "Express A");
        Train train2 = new Train("456", "Express B");

        // Create schedules object
        Schedule schedule1 = new Schedule(train1, platform1, LocalTime.of(10, 0), LocalTime.of(10, 30));
        Schedule schedule2 = new Schedule(train2, platform1, LocalTime.of(10, 15), LocalTime.of(10, 45)); // This should cause a conflict
        Schedule schedule3 = new Schedule(train2, platform2, LocalTime.of(11, 0), LocalTime.of(11, 30));

        // Add schedules to station
        station.addSchedule(schedule1); // Should succeed
        station.addSchedule(schedule2); // Should detect conflict
        station.addSchedule(schedule3); // Should succeed

        // Register waiting trains
        Train train3 = new Train("123", "Soda Express");
        station.registerWaitingTrain(train3);

        // Notify trains of available platform
        station.notifyTrainsOfAvailablePlatform(); // Should notify train3 if any platform is available

        // Create booking system
        BookingSystem bookingSystem = new BookingSystem();

        // Book tickets
        bookingSystem.bookTicket("Rahul Kr", train1, "A1");
        bookingSystem.bookTicket("Ramesh Kr", train2, "A2");
    }
}
