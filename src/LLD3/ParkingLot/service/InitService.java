package LLD3.ParkingLot.service;

import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.ParkingFloor;
import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.model.ParkingSpot;
import LLD3.ParkingLot.model.constant.*;
import LLD3.ParkingLot.repository.GateRepository;
import LLD3.ParkingLot.repository.ParkingFloorRepository;
import LLD3.ParkingLot.repository.ParkingLotRepository;
import LLD3.ParkingLot.repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private GateRepository gateRepository;

    public InitService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public ParkingLot init() {
        System.out.println("*****Starting Initialisation*****");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Providence Mall parking");
        parkingLot.setAddress("Mill road, Orleanpet");
        parkingLot.setCapacity(100);
        parkingLot.setParkingLotStatus(ParkingLotStatus.PARKING_LOT_OPEN);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.TWO_WHEELER, VehicleType.FOUR_WHEELER));
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++)
        {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.PARKING_FLOOR_AVAILABLE);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            for(int j = 1 ; j <= 10 ; j++)
            {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setNumber((i*100)+j);
                parkingSpot.setId((i*100)+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.PARKING_SPOT_AVAILABLE);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);

            }
            parkingFloor.setParkingSpots(parkingSpots);
            Gate entryGate = new Gate();
            entryGate.setGateNumber((i * 2) + 1);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setGateStatus(GateStatus.GATE_OPEN);
            entryGate.setId((i * 2) + 1);
            entryGate.setOperator("Operator: " + i + 1);
            gateRepository.put(entryGate);
            parkingFloor.setEntryGate(entryGate);

            Gate exitGate = new Gate();
            exitGate.setGateNumber((i * 2) + 2);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setGateStatus(GateStatus.GATE_OPEN);
            exitGate.setId((i * 2) + 2);
            exitGate.setOperator("Operator: " + i + 2);
            gateRepository.put(exitGate);
            parkingFloor.setExitGate(exitGate);

            parkingFloors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }
        parkingLot.setFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.get(1);
    }
}
