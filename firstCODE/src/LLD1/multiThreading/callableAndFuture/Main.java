package LLD1.multiThreading.callableAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String args[]) throws ExecutionException, InterruptedException
    {
        ProductPriceCalculation ppc = new ProductPriceCalculation();
        DeliveryChargeCalculation dcc = new DeliveryChargeCalculation();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future <Integer> ppc_value = executor.submit(ppc);
        Future <Integer> dcc_value = executor.submit(dcc);
        Integer ppc_get = ppc_value.get();
        Integer dcc_get = dcc_value.get();
        System.out.println("Product Price: " + ppc_get);
        System.out.println("Delivery Charge: " + dcc_get);
        int total = ppc_get + dcc_get;
        System.out.println("Total amount: " + total);
        executor.shutdown();
    }
}
