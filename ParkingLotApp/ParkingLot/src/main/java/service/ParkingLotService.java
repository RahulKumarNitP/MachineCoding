package service;

import common.ParkingSpot;
import common.ParkingSpotType;
import common.Vehicle;
import common.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private int capacity;
    private int carSpotsAvailable;
    private int motorcycleSpotsAvailable;
    private Map<String, ParkingSpot> carSpots;
    private Map<String, ParkingSpot> motorcycleSpots;

    public ParkingLotService(int carCapacity, int motorcycleCapacity) {
        this.capacity = carCapacity + motorcycleCapacity;
        this.carSpotsAvailable = carCapacity;
        this.motorcycleSpotsAvailable = motorcycleCapacity;
        this.carSpots = new HashMap<>();
        this.motorcycleSpots = new HashMap<>();
    }

    public boolean isFull(VehicleType vehicleType) {
        if(vehicleType==VehicleType.CAR) {
            return carSpotsAvailable<=0;
        } else if (vehicleType==VehicleType.MOTORCYCLE) {
            return motorcycleSpotsAvailable <=0;
        }

        return false;
    }

    public boolean parkVehicle(Vehicle vehicle) {

        if (isFull(vehicle.getVehicleType())) {
            return false;
        }

        if (vehicle.getVehicleType() == VehicleType.CAR) {
            if (carSpotsAvailable > 0) {
                ParkingSpot spot = new ParkingSpot("C-" + carSpotsAvailable, vehicle, ParkingSpotType.CAR_SPOT);
                carSpots.put(vehicle.getRegistrationNumber(), spot);
                carSpotsAvailable--;
                return true;
            }
        } else if (vehicle.getVehicleType() == VehicleType.MOTORCYCLE) {
            if (motorcycleSpotsAvailable > 0) {
                ParkingSpot spot = new ParkingSpot("M-" + motorcycleSpotsAvailable, vehicle, ParkingSpotType.MOTORCYCLE_SPOT);
                motorcycleSpots.put(vehicle.getRegistrationNumber(), spot);
                motorcycleSpotsAvailable--;
                return true;
            }
        }

        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType() == VehicleType.CAR) {
            ParkingSpot spot = carSpots.get(vehicle.getRegistrationNumber());
            if (spot != null) {
                carSpots.remove(vehicle.getRegistrationNumber());
                spot.setOccupied(false);
                carSpotsAvailable++;
            }
        } else if (vehicle.getVehicleType() == VehicleType.MOTORCYCLE) {
            ParkingSpot spot = motorcycleSpots.get(vehicle.getRegistrationNumber());
            if (spot != null) {
                motorcycleSpots.remove(vehicle.getRegistrationNumber());
                motorcycleSpotsAvailable++;
            }
        }
    }

    public int getAvailableSpotsCount(VehicleType type) {
        return type == VehicleType.CAR ? carSpotsAvailable : motorcycleSpotsAvailable;
    }

    public int currentCapacity() {
        return carSpotsAvailable + motorcycleSpotsAvailable;
    }

    public List<ParkingSpot> allOccupiedSpots() {
        List<ParkingSpot> occupiedspot = new ArrayList<>();
        for (ParkingSpot value : carSpots.values()) {
           if(value.isOccupied()) {
               occupiedspot.add(value);
           }
        }

        for(ParkingSpot value : motorcycleSpots.values()) {
            if(value.isOccupied()) {
                occupiedspot.add(value);
            }
        }
        return occupiedspot;
    }
}