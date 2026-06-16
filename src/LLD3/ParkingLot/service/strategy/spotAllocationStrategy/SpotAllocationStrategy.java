package LLD3.ParkingLot.service.strategy.spotAllocationStrategy;

import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.model.ParkingSpot;
import LLD3.ParkingLot.model.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot getSpotForVehicle(Vehicle vehicle, ParkingLot parkingLot);
}
