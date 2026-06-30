package LLD2.command;

public class LightOnCommand implements Command
{
    private Light light;

    @Override
    public void execute()
    {
        light.turnOn();
    }
}
