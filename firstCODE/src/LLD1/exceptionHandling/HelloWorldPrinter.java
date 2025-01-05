package LLD1.exceptionHandling;

public class HelloWorldPrinter
{
    static int x;
    public static void print()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println("Hello World");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void helloWorld() throws InterruptedException // (throws)->propagates the exception upwards
    {
        Thread.sleep(1000);
        System.out.println("Hello World");
    }
    // Checked -> which we need to handle [ if we dont handle compiler would throw an error at compile time]
    // Unchecked -> which we should handle [ if we dont handle compiler would not throw an error at compile time]
}
