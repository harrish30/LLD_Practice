package LLD1.multiThreading.semaphore;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class Main
{
    public static void main(String args[])
    {
        int maxSize = 5;
        Queue <Shirt> q = new LinkedList<>();
        Semaphore semaprod = new Semaphore(5);
        Semaphore semacust = new Semaphore(0);

        Producer p1 = new Producer(q, "p1", maxSize, semaprod, semacust);
        Producer p2 = new Producer(q, "p2", maxSize, semaprod, semacust);
        Producer p3 = new Producer(q, "p3", maxSize, semaprod, semacust);
        Producer p4 = new Producer(q, "p4", maxSize, semaprod, semacust);
        Producer p5 = new Producer(q, "p5", maxSize, semaprod, semacust);

        Customer c1 = new Customer(q, "c1", semaprod, semacust);
        Customer c2 = new Customer(q, "c2", semaprod, semacust);
        Customer c3 = new Customer(q, "c3", semaprod, semacust);
        Customer c4 = new Customer(q, "c4", semaprod, semacust);
        Customer c5 = new Customer(q, "c5", semaprod, semacust);

        Thread tp1 = new Thread(p1);
        tp1.start();
        Thread tp2 = new Thread(p2);
        tp2.start();
        Thread tp3 = new Thread(p3);
        tp3.start();
        Thread tp4 = new Thread(p4);
        tp4.start();
        Thread tp5 = new Thread(p5);
        tp5.start();

        Thread tc1 = new Thread(c1);
        tc1.start();
        Thread tc2 = new Thread(c2);
        tc2.start();
        Thread tc3 = new Thread(c3);
        tc3.start();
        Thread tc4 = new Thread(c4);
        tc4.start();
        Thread tc5 = new Thread(c5);
        tc5.start();
    }
}
