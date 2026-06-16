package LLD2.decorator;

public class Chococone implements IceCream
{
    private IceCream iceCream;
    Chococone()
    {

    }

    Chococone(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }

    @Override
    public int getCost()
    {
        if(iceCream != null) //if cone is not the base
        {
            return iceCream.getCost() + 10;
        }
        else //if cone is base
        {
            return 10;
        }
    }

    @Override
    public String getDescription()
    {
        if(iceCream != null)
        {
            return iceCream.getDescription() + "Chococone ";
        }
        else
        {
            return "Chococone ";
        }
    }
}
