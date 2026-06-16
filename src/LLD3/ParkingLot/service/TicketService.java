package LLD3.ParkingLot.service;

import LLD3.ParkingLot.model.ParkingLot;
import LLD3.ParkingLot.model.ParkingSpot;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.Vehicle;
import LLD3.ParkingLot.model.constant.ParkingSpotStatus;
import LLD3.ParkingLot.repository.GateRepository;
import LLD3.ParkingLot.repository.ParkingLotRepository;
import LLD3.ParkingLot.repository.ParkingSpotRepository;
import LLD3.ParkingLot.repository.TicketRepository;
import LLD3.ParkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategy;
import LLD3.ParkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategyFactory;
import LLD3.ParkingLot.service.strategy.spotAllocationStrategy.SpotAllocationStrategyName;

import java.time.LocalDateTime;

public class TicketService
{
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int gateId, int parkingLotId)
    {
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.getSpotAllocationStrategy(SpotAllocationStrategyName.LINEAR_SPOT_ALLOCATION_STRATEGY);
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);

        ParkingSpot parkingSpot = spotAllocationStrategy.getSpotForVehicle(vehicle, parkingLot);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.PARKING_SPOT_OCCUPIED);
        parkingSpot.setVehicle(vehicle);
        parkingSpotRepository.put(parkingSpot);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryGate(gateRepository.get(gateId));
        return ticketRepository.put(ticket);
    }
}
