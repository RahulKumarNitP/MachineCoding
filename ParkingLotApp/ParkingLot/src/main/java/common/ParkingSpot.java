package common;

import lombok.Data;

@Data
public class ParkingSpot {
    private String spotNumber;
    private Vehicle vehicle;
    private boolean isOccupied;
    private ParkingSpotType spotType;

    public ParkingSpot(String spotNumber, Vehicle vehicle, ParkingSpotType spotType) {
        this.spotNumber = spotNumber;
        this.vehicle = vehicle;
        this.spotType = spotType;
        this.isOccupied = true;
    }
}