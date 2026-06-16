package LLD1.methodOverriding;

public class electric extends car
{
    @Override // optional annotation, which improves the readability, by showing the reader that this method is overridden
    public void startEngine()
    {
        System.out.println("Starting battery pack");
        System.out.println("Starting the motor");
    }
}
