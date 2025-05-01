package LLD3.ParkingLot.service.strategy.billCalculationStrategy;

import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.enums.BillStatus;
import LLD3.ParkingLot.repository.GateRepository;
import LLD3.ParkingLot.repository.TicketRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleBillCalculationStrategy implements BillCalculationStrategy
{
    //1 sec is 1 Rs.
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate, TicketRepository ticketRepository)
    {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfSeconds = ChronoUnit.SECONDS.between(entryTime, exitTime);
        double amount = numberOfSeconds;
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        bill.setId(exitTime.hashCode());
        bill.setBillStatus(BillStatus.BILL_UNPAID);
        bill.setExitGate(exitGate);
        return bill;
    }
}