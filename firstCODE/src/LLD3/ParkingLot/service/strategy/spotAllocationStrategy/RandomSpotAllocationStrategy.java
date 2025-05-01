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
import java.util.Random;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy
{
    @Override
    public ParkingSpot getSpotForVehicle(Vehicle vehicle, ParkingLot parkingLot)
    {
        List<ParkingFloor> parkingFloors = parkingLot.getFloors();
        Random random = new Random();
        if(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.PARKING_LOT_OPEN))
        {
            for(ParkingFloor parkingFloor: parkingFloors)
            {
                if(parkingFloor.getParkingFloorStatus().equals(ParkingFloorStatus.PARKING_FLOOR_AVAILABLE))
                {
                    List <ParkingSpot> parkingSpots = parkingFloor.getParkingSpots();
                    int [] doesItExist = new int [parkingSpots.size()];
                    int count = 0;
                    while(count < 10)
                    {
                        ParkingSpot parkingSpot = parkingSpots.get(random.nextInt(parkingSpots.size()));
                        if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.PARKING_SPOT_AVAILABLE)
                                && parkingSpot.getVehicleType().equals(vehicle.getVehicleType()))
                        {
                            parkingSpot.setVehicle(vehicle);
                            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.PARKING_SPOT_OCCUPIED);
                            return parkingSpot;
                        }
                        else
                        {
                            int parkingSpotID = (parkingSpot.getId() % 100) - 1;
                            if(doesItExist[parkingSpotID] == 0)
                            {
                                doesItExist[parkingSpotID] = 1;
                                count++;
                            }
                        }
                    }
                }
            }
        }
        throw new ParkingSpotNotFoundForVehicleException("Sorry, parking spot not found for your vehicle type");
    }
}
