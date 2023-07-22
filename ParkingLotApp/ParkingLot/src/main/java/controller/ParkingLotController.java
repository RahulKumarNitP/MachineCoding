package controller;

import common.ParkingSpot;
import common.Vehicle;
import common.VehicleType;
import service.ParkingLotService;

import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLot;

    public ParkingLotController(int carCapacity, int motorcycleCapacity) {
        parkingLot = new ParkingLotService(carCapacity, motorcycleCapacity);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        parkingLot.removeVehicle(vehicle);
    }

    public int getAvailableSpotsCount(VehicleType type) {
        return parkingLot.getAvailableSpotsCount(type);
    }

    public int getCurrentCapacity() {
        return parkingLot.currentCapacity();
    }

    public List<ParkingSpot> getAllOccupiedSpots() {
        return parkingLot.allOccupiedSpots();
    }
}