package LLD1.inheritance;

public class instructor extends user
{
    int avgrating;
    public instructor(String name, String email, String password)
    {
        super(name, email, password);
    }
    public void printdetails()
    {
        System.out.print(name + " " + email + " " + avgrating);
    }
}
