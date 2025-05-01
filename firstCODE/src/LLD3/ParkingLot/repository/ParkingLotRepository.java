package LLD3.ParkingLot.repository;

import LLD3.ParkingLot.exception.ParkingLotNotFoundException;
import LLD3.ParkingLot.model.ParkingLot;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;
    private static int idCounter = 0;
    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId)
    {
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null)
        {
            throw new ParkingLotNotFoundException("ParkingLot not found for id: " + parkingLotId);
        }
        return parkingLot;
    }
    public void put(ParkingLot parkingLot)
    {
        parkingLot.setId(++idCounter);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking lot has been successfully added");
    }
}
