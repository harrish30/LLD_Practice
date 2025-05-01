package LLD3.ParkingLot.controller;
import LLD3.ParkingLot.exception.InvalidRequestException;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.model.Vehicle;
import LLD3.ParkingLot.service.TicketService;

public class TicketController
{
    private TicketService ticketService;

    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(Vehicle vehicle, int gateId,  int parkingLotId)
    {
        if(gateId <= 0 || parkingLotId <= 0)
        {
            throw new InvalidRequestException("Please enter valid request");
        }
        return ticketService.generateTicket(vehicle, gateId, parkingLotId);
    }
}
