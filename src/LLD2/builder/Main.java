package LLD2.builder;

public class Main
{
    public static void main(String args[])
    {
        Student s = Student.builder()
                .setName("Harrish M")
                .setId(1)
                .setAge(24)
//                .setPSP()
//                .setPhoneNumber()
//                .setUniversityName()
                .setGradYear(2021)
                .build();
        System.out.println(s);
    }
}