package LLD2.decorator;

public class Chocosyrup implements IceCream
{
    private IceCream iceCream;
    Chocosyrup(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }
    @Override
    public int getCost()
    {
        return iceCream.getCost() + 10;
    }

    @Override
    public String getDescription()
    {
        return iceCream.getDescription() + "Chocosyrup ";
    }
}
