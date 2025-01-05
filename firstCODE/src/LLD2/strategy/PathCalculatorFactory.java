package LLD2.strategy;

public class PathCalculatorFactory
{
    public static PathCalculator modeofTransportCalculator(Mode mode)
    {
        switch(mode)
        {
            case BIKE: return new BikePathCalculator();
            case CAR: return new CarPathCalculator();
            case WALK: return new WalkPathCalculator();
            default: return null;
        }
    }
}
