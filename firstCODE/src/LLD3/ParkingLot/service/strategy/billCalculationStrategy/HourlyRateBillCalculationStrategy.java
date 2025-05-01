package LLD3.ParkingLot.service.strategy.billCalculationStrategy;

import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.enums.BillStatus;
import LLD3.ParkingLot.repository.TicketRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyRateBillCalculationStrategy implements BillCalculationStrategy
{
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate, TicketRepository ticketRepository)
    {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfHours = ChronoUnit.HOURS.between(entryTime, exitTime);
        int hourlyRate = 10;
        double amount = 20 + (numberOfHours * hourlyRate);
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
