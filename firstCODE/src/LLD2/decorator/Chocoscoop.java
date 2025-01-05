package LLD2.decorator;

public class Chocoscoop implements IceCream
{
    private IceCream iceCream;
    Chocoscoop(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }
    @Override
    public int getCost()
    {
        return iceCream.getCost() + 20;
    }

    @Override
    public String getDescription()
    {
        return iceCream.getDescription() + "Chocoscoop ";
    }
}
