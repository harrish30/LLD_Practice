package LLD2.decorator;

public class Main
{
    public static void main(String[] args)
    {
        IceCream iceCream = new Chocochip(new Chocoscoop(new Orangecone(new Chocosyrup(new Chococone()))));
        System.out.println(iceCream.getCost());
        System.out.println(iceCream.getDescription());
    }
}
