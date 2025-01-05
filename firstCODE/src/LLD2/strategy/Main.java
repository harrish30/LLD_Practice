package LLD2.strategy;

public class Main
{
    public static void main(String[] args)
    {
        Maps maps = Maps.getInstance();
        maps.findPath("Pondicherry", "Chennai", Mode.WALK);
    }
}