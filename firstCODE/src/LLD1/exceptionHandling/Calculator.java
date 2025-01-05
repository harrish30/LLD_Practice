package LLD1.exceptionHandling;

import java.util.Scanner;

public class Calculator
{
    public void divide(String a, String b)
    {
        Scanner scn = new Scanner(System.in);
        try
        {
//            int n = scn.nextInt();
            if(a == null || b == null)
            {
                throw new NullPointerException("Input parameters can't be null");
            }
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            System.out.println(x/y);
        }
        catch (ArithmeticException f)
        {
            System.out.println("Don't divide by 0");
        }
        catch (NumberFormatException f)
        {
            System.out.println("Make the numbers in number format");
        }
        catch (Exception f)
        {
            System.out.println(f.getMessage());
            f.printStackTrace(); //It's a very simple, but very useful tool for diagnosing an exceptions.
            // It tells you what happened and where in the code this happened.
        }
        finally //no matter what happens finally block will always execute
        {
            scn.close();
        }
    }
    public void finalise() // finalise is a method called before destroying an object of that class
    {
        System.out.println("Calculator object is being destroyed");
    }
}
