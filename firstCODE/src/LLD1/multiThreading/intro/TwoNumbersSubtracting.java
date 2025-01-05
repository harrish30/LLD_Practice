package LLD1.multiThreading.intro;

public class TwoNumbersSubtracting implements Runnable
{
    int x;
    int y;
    TwoNumbersSubtracting(int a, int b)
    {
        x = a;
        y = b;
    }
    @Override
    public void run()
    {
        System.out.println("Subtraction running in: " + Thread.currentThread().getName());
        System.out.println(x - y);
    }
}
