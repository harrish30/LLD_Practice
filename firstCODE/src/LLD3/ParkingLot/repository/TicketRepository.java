package LLD3.ParkingLot.repository;

import LLD3.ParkingLot.exception.TicketNotFoundException;
import LLD3.ParkingLot.model.Ticket;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository
{
    private Map <Integer, Ticket> ticketMap;
    private static int idCounter = 0;

    public TicketRepository()
    {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId)
    {
        Ticket ticket = ticketMap.get(ticketId);
        if(ticket == null)
        {
            throw new TicketNotFoundException("Ticket not found for id: " + ticketId);
        }
        return ticket;
    }

    public void remove(int ticketId)
    {
        if(ticketMap.containsKey(ticketId))
        {
            ticketMap.remove(ticketId);
        }
    }

    public int size()
    {
        return ticketMap.size();
    }
    public Ticket put(Ticket ticket)
    {
        ticket.setId(++idCounter);
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("Ticket has been successfully added");
        return ticketMap.get(idCounter);
    }
}
