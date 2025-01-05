package LLD1.multiThreading.synchronisationProblem;
import java.util.concurrent.locks.ReentrantLock;
public class Main
{
    public static void main(String [] args)
    {
        ReentrantLock mutex = new ReentrantLock();
        Count c = new Count(0);
        Adder add = new Adder(c, mutex);
        Subtractor sub = new Subtractor(c,mutex);
        Thread t1 = new Thread(add);
        Thread t2 = new Thread(sub);
        t1.start();
        t2.start();
        System.out.print(c.getC());
    }
}
