package LLD2.singleton;

public class Main
{
    public static void main(String [] args)
    {
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1);
        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);
        Singleton s3 = Singleton.getInstance();
        System.out.println(s3);
        Singleton s4 = Singleton.getInstance();
        System.out.println(s4);
        Singleton s5 = Singleton.getInstance();
        System.out.println(s5);
        DBconn db = DBconn.getConnection();
        System.out.println(db);
        System.out.println(db.connect());
    }
}
