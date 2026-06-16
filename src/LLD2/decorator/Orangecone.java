package LLD2.decorator;

public class Orangecone implements IceCream
{
    private IceCream iceCream;
    Orangecone()
    {

    }

    Orangecone(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }

    @Override
    public int getCost()
    {
        if(iceCream != null) //if cone is not the base
        {
            return iceCream.getCost() + 12;
        }
        else //if cone is base
        {
            return 12;
        }
    }

    @Override
    public String getDescription()
    {
        if(iceCream != null)
        {
            return iceCream.getDescription() + "Orangecone ";
        }
        else
        {
            return "Orangecone ";
        }
    }
}
