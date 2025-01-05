package LLD2.flyweight;

public class Circle implements Shape
{
    private String colour;
    Circle(String colour)
    {
        this.colour = colour;
    }
    @Override
    public void draw(int x, int y)
    {
        System.out.println("The colour of circle is: " + colour + " located at " + x + ", " + y);
    }
}
