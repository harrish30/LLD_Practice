package LLD1.multiThreading.callableAndFuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class ProductPriceCalculation implements Callable
{
    @Override
    public Integer call()
    {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println("Product Price Thread: " + Thread.currentThread().getName());
        return i;
    }
}
