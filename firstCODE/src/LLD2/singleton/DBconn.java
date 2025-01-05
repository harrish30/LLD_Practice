package LLD2.singleton;

public class DBconn
{
    private int noOfConn = 0;
    private final int limit = 10;
    private static DBconn instance;
    private DBconn()
    {

    }
    public static DBconn getConnection()
    {
        if(instance == null)
        {
            instance = new DBconn();
        }
        return instance;
    }
    public boolean connect()
    {
        if(noOfConn <= limit)
        {
            noOfConn++;
            System.out.println(noOfConn);
            return true;
        }
        else
        {
            return false;
        }
    }
}
