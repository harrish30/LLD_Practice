package LLD2.flyweight;
public class Main
{
    private static String [] colours = {"red", "yellow", "white", "blue", "black"};
    public static void main(String[] args)
    {
        for(int i = 1 ; i <= 20 ; i++)
        {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColour());
            circle.draw(getRandomx(), getRandomy());
        }
    }
    private static String getRandomColour()
    {
        int a = (int) Math.random() * colours.length;
        return colours[a];
    }
    private static int getRandomx()
    {
        int x = (int) Math.random() * 100;
        return x;
    }
    private static int getRandomy()
    {
        int y = (int) Math.random() * 100;
        return y;
    }
}