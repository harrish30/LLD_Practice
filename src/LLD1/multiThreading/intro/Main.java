package LLD1.multiThreading.intro;

public class Main
{
    public static void main(String [] args)
    {
//        HelloWorldPrinter temp = new HelloWorldPrinter();
//        Thread t = new Thread(temp);
//        t.start();
        System.out.println("This is running in: " + Thread.currentThread().getName());
        TwoNumbersAdding add = new TwoNumbersAdding(2, 5);
        Thread temp1 = new Thread(add);
        temp1.start();
        TwoNumbersSubtracting sub = new TwoNumbersSubtracting(5, 2);
        Thread temp2 = new Thread(sub);
        temp2.start();
    }
}
