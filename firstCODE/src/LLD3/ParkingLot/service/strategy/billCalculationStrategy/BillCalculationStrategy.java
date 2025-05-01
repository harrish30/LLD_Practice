package LLD3.ParkingLot.service.strategy.billCalculationStrategy;

import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.repository.TicketRepository;

public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket, Gate exitGate, TicketRepository ticketRepository);
}
