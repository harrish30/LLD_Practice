package LLD2.strategy;

public class Maps
{
    private static Maps instance;
    private Maps()
    {

    }
    public static Maps getInstance()
    {
        if(instance == null)
        {
            synchronized(Maps.class)
            {
                if(instance == null)
                {
                    instance = new Maps();
                }
            }
        }
        return instance;
    }
    public void findPath(String source, String destination, Mode mode)
    {
        PathCalculator pathCalculator = PathCalculatorFactory.modeofTransportCalculator(mode);
        pathCalculator.pathFinder(source, destination);
    }
}
