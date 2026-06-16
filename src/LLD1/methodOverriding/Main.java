package LLD1.methodOverriding;

public class Main
{
    public static void main(String [] args)
    {
        car vehicle = new iceCar();
        vehicle.startEngine();

//        iceCar vehicle = new iceCar();
//        vehicle.startEngine();
//        vehicle.printDetails();
    }
}
