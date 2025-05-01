package LLD3.ParkingLot.service.strategy.billCalculationStrategy;

import LLD3.ParkingLot.model.Gate;
import LLD3.ParkingLot.model.Ticket;
import LLD3.ParkingLot.repository.TicketRepository;

public class BillCalculationStrategyFactory
{
    // TODO : add SurgeBillCalculationStrategy with enum and update here
    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategyName billCalculationStrategyName)
    {
        return switch(billCalculationStrategyName)
        {
            case HOURLY_RATE_BILL_CALCULATION_STRATEGY -> new HourlyRateBillCalculationStrategy();
            case SIMPLE_BILL_CALCULATION_STRATEGY -> new SimpleBillCalculationStrategy();
            case SURGE_BILL_CALCULATION_STRATEGY -> new SimpleBillCalculationStrategy();
        };
    }
}
