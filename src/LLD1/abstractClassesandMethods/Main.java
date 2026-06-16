package LLD1.abstractClassesandMethods;

public class Main
{
    public static void main(String [] args)
    {
        car vehicle = new electric(5);
        vehicle.startEngine();
        System.out.print(vehicle.noOfWheels);
    }
}