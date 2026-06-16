package LLD3.ParkingLot.service.strategy.billCalculationStrategy;
import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.constant.BillStatus;
import LLD3.ParkingLot.repository.TicketRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SurgeBillCalculationStrategy implements BillCalculationStrategy
{
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate, TicketRepository ticketRepository)
    {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfHours = ChronoUnit.HOURS.between(entryTime, exitTime);
        int hourlyRate = 10;
        long amount = 20 + (numberOfHours * hourlyRate);
        int activeTickets = ticketRepository.size();
        int capacity = 100; //hardcoded since it needs parkingLotID and parkingLotRepository which makes it complex, can be done though
        long surgePercent = (long) Math.floor((activeTickets / capacity) * 100);
        double surge = 0;
        if(surgePercent > 50 && surgePercent <= 75)
        {
            surge = 0.5;
        }
        else if(surgePercent > 75 && surgePercent <= 90)
        {
            surge = 0.75;
        }
        else if(surgePercent > 90 && surgePercent <= 100)
        {
            surge = 0.9;
        }
        double surgeAmount = amount + (amount * surge);
        Bill bill = new Bill();
        bill.setAmount(surgeAmount);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        bill.setId(exitTime.hashCode());
        bill.setBillStatus(BillStatus.BILL_UNPAID);
        bill.setExitGate(exitGate);
        return bill;
    }
}