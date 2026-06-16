package LLD1.multiThreading.semaphore;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class Customer implements Runnable
{
    private Queue <Shirt> shop;
    private String name;
    private int maxSize;
    private Semaphore semaprod;
    private Semaphore semacust;
    public Customer(Queue <Shirt> shop, String name, Semaphore semaprod, Semaphore semacust)
    {
        this.shop = shop;
        this.name = name;
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
                semacust.acquire(); // reduce the count for consumer by 1
                System.out.println("Current Size: " + shop.size() + " Customer name: " + name);
                shop.remove(); // removes a single shirt from store
                semaprod.release(); // increase the count for producer by 1
            }
            catch(Exception e)
            {
                e.getMessage();
            }
        }
    }
}
