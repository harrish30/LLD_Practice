package LLD3.ParkingLot.service;

import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.model.ParkingSpot;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.enums.ParkingSpotStatus;
import LLD3.ParkingLot.repository.BillRepository;
import LLD3.ParkingLot.repository.GateRepository;
import LLD3.ParkingLot.repository.ParkingSpotRepository;
import LLD3.ParkingLot.repository.TicketRepository;
import LLD3.ParkingLot.service.strategy.billCalculationStrategy.BillCalculationStrategy;
import LLD3.ParkingLot.service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import LLD3.ParkingLot.service.strategy.billCalculationStrategy.BillCalculationStrategyName;

public class BillService
{
    private BillRepository billRepository;
    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private GateRepository gateRepository;

    public BillService(BillRepository billRepository, TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository, GateRepository gateRepository) {
        this.billRepository = billRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public Bill generateBill(int ticketID, int exitGateId)
    {
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBillCalculationStrategy(BillCalculationStrategyName.SURGE_BILL_CALCULATION_STRATEGY);
        Bill bill = billCalculationStrategy.generateBill(ticketRepository.get(ticketID), gateRepository.get(exitGateId), ticketRepository);

        //release the parking spot
        Ticket ticket = ticketRepository.get(ticketID);
        ParkingSpot tempParkingSpot = ticket.getParkingSpot();
        int parkingSpotId = tempParkingSpot.getId();
        ParkingSpot parkingSpot =  parkingSpotRepository.get(parkingSpotId);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.PARKING_SPOT_AVAILABLE);
        parkingSpot.setVehicle(null);
        ticketRepository.remove(ticketID);

        billRepository.put(bill);
        return bill;
    }
}
