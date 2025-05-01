package LLD3.ParkingLot.controller;

import LLD3.ParkingLot.exception.InvalidInputException;
import LLD3.ParkingLot.model.Bill;
import LLD3.ParkingLot.service.BillService;

public class BillController
{
    private BillService billService;

    public BillController(BillService billService)
    {
        this.billService = billService;
    }
    public Bill generateBill(int ticketID, int exitGateId)
    {
        if(ticketID <= 0 || (exitGateId % 2 == 1) || exitGateId <= 0)
        {
            throw new InvalidInputException("Please enter valid input");
        }
        return billService.generateBill(ticketID, exitGateId);
    }
}
