package LLD3.ParkingLot.service.strategy.spotAllocationStrategy;

import LLD3.ParkingLot.exception.ParkingSpotNotFoundForVehicleException;
import LLD3.ParkingLot.model.ParkingFloor;
import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.model.ParkingSpot;
import LLD3.ParkingLot.model.Vehicle;
import LLD3.ParkingLot.model.enums.ParkingFloorStatus;
import LLD3.ParkingLot.model.enums.ParkingLotStatus;
import LLD3.ParkingLot.model.enums.ParkingSpotStatus;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy
{
    @Override
    public ParkingSpot getSpotForVehicle(Vehicle vehicle, ParkingLot parkingLot)
    {
        List <ParkingFloor> parkingFloors = parkingLot.getFloors();
        //TODO : add the required validations
        if(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.PARKING_LOT_OPEN))
        {
            for(ParkingFloor parkingFloor: parkingFloors)
            {
                if(parkingFloor.getParkingFloorStatus().equals(ParkingFloorStatus.PARKING_FLOOR_AVAILABLE))
                {
                    List <ParkingSpot> parkingSpots = parkingFloor.getParkingSpots();
                    for(ParkingSpot parkingSpot: parkingSpots)
                    {
                        if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.PARKING_SPOT_AVAILABLE)
                                && parkingSpot.getVehicleType().equals(vehicle.getVehicleType()))
                        {
                            parkingSpot.setVehicle(vehicle);
                            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.PARKING_SPOT_OCCUPIED);
                            return parkingSpot;
                        }
                    }
                }
            }
        }
        throw new ParkingSpotNotFoundForVehicleException("Sorry, parking spot not found for your vehicle type");
    }
}
