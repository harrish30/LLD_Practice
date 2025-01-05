package LLD1.abstractClassesandMethods;

public abstract class car
{
    protected int noOfWheels;
    private int enginePower;
    public abstract void startEngine();
    //some structure -> that allows both abstract method and some attributes
    // Interface -> won't work as it does not allow attributes
    // Abstract class -> works(attributes are allowed)
}