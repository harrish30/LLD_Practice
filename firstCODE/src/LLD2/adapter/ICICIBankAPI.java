package LLD2.adapter;

public class ICICIBankAPI
{
    public double checkBalance(String userToken)
    {
        return 1000;
    }
    public int tranferMoney(String senderToken, String ReceiverToken, double amount)
    {
        return 1;
    }
    public boolean changePin(String userToken, int newPin, int currPin)
    {
        return true;
    }
}
