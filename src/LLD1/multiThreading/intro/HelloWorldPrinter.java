package LLD1.multiThreading.intro;

public class HelloWorldPrinter implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("This is running in: " + Thread.currentThread().getName());
    }
}
