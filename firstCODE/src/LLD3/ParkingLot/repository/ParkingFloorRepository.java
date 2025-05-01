package LLD3.ParkingLot.repository;

import LLD3.ParkingLot.exception.ParkingFloorNotFoundException;
import LLD3.ParkingLot.model.ParkingFloor;
import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId)
    {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null)
        {
            throw new ParkingFloorNotFoundException("Parking floor not found for id: " + parkingFloorId);
        }
        return parkingFloor;
    }
    public void put(ParkingFloor parkingFloor)
    {
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        System.out.println("Parking floor has been successfully added");
    }
}
