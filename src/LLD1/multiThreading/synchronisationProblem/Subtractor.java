package LLD1.multiThreading.synchronisationProblem;
import java.util.concurrent.locks.ReentrantLock;
public class Subtractor implements Runnable
{
    private Count c;
    private ReentrantLock mutex;
    public Subtractor(Count count, ReentrantLock m)
    {
        c = count;
        mutex = m;
    }
    @Override
    public void run()
    {
        for(int i = 1 ; i <= 1000000 ; i++)
        {
            mutex.lock();
            c.setC(c.getC() - 1);
            mutex.unlock();
        }
    }
}
