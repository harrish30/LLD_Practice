package LLD2.decorator;

public class Chocochip implements IceCream
{
    private IceCream iceCream;
    Chocochip(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }
    @Override
    public int getCost()
    {
        return iceCream.getCost() + 5;
    }

    @Override
    public String getDescription()
    {
        return iceCream.getDescription() + "Chocochip ";
    }
}
