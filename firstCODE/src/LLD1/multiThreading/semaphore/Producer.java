package LLD1.multiThreading.semaphore;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class Producer implements Runnable
{
    private Queue <Shirt> shop;
    private String name;
    private int maxSize;
    private Semaphore semaprod;
    private Semaphore semacust;
    public Producer(Queue <Shirt> shop, String name, int maxSize, Semaphore semaprod, Semaphore semacust)
    {
        this.shop = shop;
        this.name = name;
        this.maxSize = maxSize;
        this.semaprod = semaprod;
        this.semacust = semacust;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                semaprod.acquire(); // reduce the number for producers by 1
                System.out.println("Current Size: " + shop.size() + " Added by producer: " + name);
                shop.add(new Shirt()); //adds a single shirt in shop
                semacust.release(); // increase the number for consumer by 1
            }
            catch(Exception e)
            {
                e.getMessage();
            }
        }
    }
}

