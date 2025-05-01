package LLD3.ParkingLot.repository;

import LLD3.ParkingLot.exception.BillNotFoundException;
import LLD3.ParkingLot.model.Bill;
import java.util.HashMap;
import java.util.Map;

public class BillRepository
{
    private Map<Integer, Bill> billMap;

    public BillRepository()
    {
        this.billMap = new HashMap<>();
    }

    public Bill get(int billId)
    {
        Bill bill = billMap.get(billId);
        if (bill == null)
        {
            throw new BillNotFoundException("Bill not found for id: " + billId);
        }
        return bill;
    }

    public void put(Bill bill)
    {
        billMap.put(bill.getId(), bill);
        System.out.println("Bill has been successfully added");
    }
}
