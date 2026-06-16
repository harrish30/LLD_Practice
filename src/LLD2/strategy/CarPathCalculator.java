package LLD2.strategy;

public class CarPathCalculator implements PathCalculator
{
    @Override
    public void pathFinder(String source, String destination)
    {
        System.out.println("Travelling by car from " + source + " to " + destination);
    }
}
