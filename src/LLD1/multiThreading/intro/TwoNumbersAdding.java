package LLD1.multiThreading.intro;

public class TwoNumbersAdding implements Runnable
{
    int x;
    int y;
    TwoNumbersAdding(int a, int b)
    {
        x = a;
        y = b;
    }
    @Override
    public void run()
    {
        System.out.println("Addition running in: " + Thread.currentThread().getName());
        System.out.println(x + y);
    }
}
