package LLD1.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList <Integer> arr = new ArrayList<>();
        Object obj = new Object();
        Student s1 = new Student(1, "Harrish");
        Student s2 = new Student(1, "Vasanth");
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        HashSet <Integer> hs = new HashSet<>();
        hs.add(1); //adds this
        hs.add(1); //doesn't add this since duplicate
        System.out.println(hs);
        Count c1 = new Count(1);
        Count c2 = new Count(1);
        System.out.println(c1.equals(c2));
        HashMap<Integer, Student> map = new HashMap<>();
//        equals() && ==
//        == -> always compares using the hashcode
//        equals() -> method
//        If we don't override equals() -> default behaviour -> internally uses ==
    }
}
