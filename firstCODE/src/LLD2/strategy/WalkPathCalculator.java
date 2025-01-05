package LLD2.strategy;

public class WalkPathCalculator implements PathCalculator
{
    @Override
    public void pathFinder(String source, String destination)
    {
        System.out.println("Travelling by walk from " + source + " to " + destination);
    }
}
