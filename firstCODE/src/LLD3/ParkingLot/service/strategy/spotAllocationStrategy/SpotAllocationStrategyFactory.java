package LLD3.ParkingLot.service.strategy.spotAllocationStrategy;

public class SpotAllocationStrategyFactory
{
    //TODO : add more spot allocation strategies, with ENUM and implement here
    //randomly & descending
    public static SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyName spotAllocationStrategyName)
    {
        return switch (spotAllocationStrategyName)
        {
            case LINEAR_SPOT_ALLOCATION_STRATEGY -> new LinearSpotAllocationStrategy();
            case REVERSE_SPOT_ALLOCATION_STRATEGY -> new ReverseSpotAllocationStrategy();
            case RANDOM_SPOT_ALLOCATION_STRATEGY -> new RandomSpotAllocationStrategy();
        };
    }
}
