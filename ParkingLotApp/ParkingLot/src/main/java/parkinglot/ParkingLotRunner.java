package parkinglot;

import common.ParkingSpot;
import common.Vehicle;
import common.VehicleType;
import controller.ParkingLotController;

import java.util.List;

public class ParkingLotRunner {
    public static void main(String[] args) {
        // Create the parking lot manager with car capacity of 10 and motorcycle capacity of 5
        ParkingLotController parkingLotManager = new ParkingLotController(10, 5);

        // Create some vehicles
        Vehicle car1 = new Vehicle("CAR-001", "Red", VehicleType.CAR);
        Vehicle motorcycle1 = new Vehicle("MOTO-001", "Blue", VehicleType.MOTORCYCLE);
        Vehicle car2 = new Vehicle("CAR-002", "White", VehicleType.CAR);
        Vehicle motorcycle2 = new Vehicle("MOTO-002", "Black", VehicleType.MOTORCYCLE);

        // Park the vehicles
        if (parkingLotManager.parkVehicle(car1)) {
            System.out.println("Car 1 parked successfully.");
        } else {
            System.out.println("No available spot for Car 1.");
        }

        if (parkingLotManager.parkVehicle(motorcycle1)) {
            System.out.println("Motorcycle 1 parked successfully.");
        } else {
            System.out.println("No available spot for Motorcycle 1.");
        }

        System.out.println("Current capacity " + parkingLotManager.getCurrentCapacity());
        List<ParkingSpot> listOf = parkingLotManager.getAllOccupiedSpots();
        for(ParkingSpot value: listOf) {
            System.out.println(value.toString());
        }
        if (parkingLotManager.parkVehicle(car2)) {
            System.out.println("Car 2 parked successfully.");
        } else {
            System.out.println("No available spot for Car 2.");
        }

        if (parkingLotManager.parkVehicle(motorcycle2)) {
            System.out.println("Motorcycle 2 parked successfully.");
        } else {
            System.out.println("No available spot for Motorcycle 2.");
        }

        // Try to park another vehicle, but the parking lot is full
        Vehicle car3 = new Vehicle("CAR-003", "Silver", VehicleType.CAR);
        if (parkingLotManager.parkVehicle(car3)) {
            System.out.println("Car 3 parked successfully.");
        } else {
            System.out.println("No available spot for Car 3.");
        }


        // Remove a vehicle from the parking lot
        parkingLotManager.removeVehicle(car1);
        parkingLotManager.removeVehicle(motorcycle1);

        System.out.println(parkingLotManager.getCurrentCapacity());

        // Check available spots
        System.out.println("Available car spots: " + parkingLotManager.getAvailableSpotsCount(VehicleType.CAR));
        System.out.println("Available motorcycle spots: " + parkingLotManager.getAvailableSpotsCount(VehicleType.MOTORCYCLE));


        System.out.println("Current capacity " + parkingLotManager.getCurrentCapacity());
        List<ParkingSpot> listOff = parkingLotManager.getAllOccupiedSpots();
        for(ParkingSpot value: listOff) {
            System.out.println(value.toString());
        }
    }
}
