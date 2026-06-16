package LLD1.lambdaAndStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class Main
{
    public static void main(String[] args)
    {
        //Anonymous class
        //instead of creating a new class for this task(printing), we can use anonymous class to code in main itself
        //implementation using Anonymous class -> can be used for any interface
        Runnable hwd = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Hello World");
            }
        };
        Thread t = new Thread(hwd);
        t.start();

        //need to use all the methods from the interface
        Car c = new Car()
        {
            @Override
            public void startEngine()
            {
                System.out.println("Engine started");
            }
            @Override
            public void startMedia()
            {
                System.out.println("Media started");
            }
        };
        c.startMedia();

        //Lambda
        Thread t1 = new Thread(() -> System.out.println("Hello World 1"));
        t1.start();
        //Lambda function can be used in interface if it's a functional interface
        Instructor <String> i = (noOfStudents, batch) ->
                System.out.println("From lambda -> Teaching: " + noOfStudents + " from batch: " + batch);
        i.teach(10, "A");
        int x = 10;
//        switch (x)
//        {
//            case 1:
//            {
//                System.out.println("Hello World");
//            }
//            case 2:
//            {
//                System.out.println("Hi Hello");
//            }
//            case 3:
//            {
//                System.out.println("Good morning");
//            }
//        }

        // enhanced switch case -> Java 14 -> Java 17+
        switch (x)
        {
            case 1 -> System.out.println("Hello World");
            case 2 -> System.out.println("case 2");
            case 3 -> System.out.println("Case 3");
            default -> System.out.println("Default");
        }

        //Enhanced for loop
        ArrayList <Integer> list = new ArrayList <> (Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        for(int j = 0 ; j < list.size() ; j++)
        {
            System.out.println(list.get(j));
        }
        //enhanced for loop, not forEach
        for(int xy : list)
        { // variable to hold the data one by one : collection
            System.out.println(xy);
        }

        //Stream -> methods to do stuff
        //collection/ map.stream()

        //forEach
        list.stream()
                .map(e -> e * e)
                .filter(e -> e % 2 != 0)
                .forEach(e -> System.out.println(e));
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
    }
}