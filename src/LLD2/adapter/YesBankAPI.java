package LLD2.adapter;

public class YesBankAPI
{
    public long getBalance(String username, String password)
    {
        return 1000;
    }
    public char doTransaction(String sender, String receiver, String senderPassword, double amount)
    {
        return 'y';
    }
    public boolean changePin(String username, String password, int currPin, int newPin)
    {
        return true;
    }
}
