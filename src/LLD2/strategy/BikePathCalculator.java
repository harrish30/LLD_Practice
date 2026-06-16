package LLD2.strategy;

public class BikePathCalculator implements PathCalculator
{
    @Override
    public void pathFinder(String source, String destination)
    {
        System.out.println("Travelling by bike from " + source + " to " + destination);
    }
}
