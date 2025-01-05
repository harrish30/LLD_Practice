package LLD1.methodOverriding;

public class iceCar extends car
{
    @Override // optional annotation, which improves the readability, by showing the reader that this method is overridden
    public void startEngine()
    {
        System.out.println("Consuming petrol/ diesel");
        System.out.println("Starting combustion");
        System.out.println("Engine starts");
    }
    public void printDetails()
    {
        System.out.println("This is an ICE Car");
    }
}
