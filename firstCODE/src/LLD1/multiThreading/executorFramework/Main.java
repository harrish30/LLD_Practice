package LLD1.multiThreading.executorFramework;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main
{
    public static void main(String[] args)
    {
//        for(int i=1;i<=100;i++)
//        {
//            NumberPrinter numberPrinter = new NumberPrinter(i);
//            Thread t = new Thread(numberPrinter);
//            t.start();
//        }
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=1;i<=100;i++)
        {
            if(i==11 || i==51 || i==99)
            {
                System.out.println("Debug");
            }
            NumberPrinter printer = new NumberPrinter(i);
            executor.submit(printer);
        }
        executor.shutdown(); // clears everything
    }
}
