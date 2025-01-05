package LLD2.flyweight;

import java.util.HashMap;

public class ShapeFactory
{
    private static final HashMap <String, Shape> hm = new HashMap<>();
    public static Shape getCircle(String colour)
    {
        Circle circle = (Circle) hm.get(colour);
        if(circle == null)
        {
            circle = new Circle(colour);
            hm.put(colour, circle);
            System.out.println("The colour of the circle is: " + colour);
        }
        return circle;
    }
    //static methods for other shapes
}
