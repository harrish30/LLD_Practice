package LLD2.command;

public class Light
{
    private boolean turnedOn;

    public boolean isTurnedOn()
    {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn)
    {
        this.turnedOn = turnedOn;
    }

    //receiver method -> receives and acts on the command
    public void turnOn()
    {
        turnedOn = true;
        System.out.println("Light has been turned on");
    }
}
