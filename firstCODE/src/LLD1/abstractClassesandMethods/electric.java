package LLD1.abstractClassesandMethods;

public class electric extends car
{
    public electric(int x)
    {
        noOfWheels = x;
    }
    public void startEngine()
    {
        System.out.println("Starting battery pack");
        System.out.println("Starting the motor");
    }

}
