package LLD2.adapter;

public class Main
{
    public static void main(String[] args)
    {
        BankAPIAdapter bankAPIAdapter = new ICICIBankAPIAdapter();
        PhonePe phonePe = new PhonePe(bankAPIAdapter);
        User harrish = new User("Harrish M", "password");
        User vasanthan = new User("Vasanthan A", "password");
        phonePe.checkBalance(harrish);
        phonePe.doTransaction(harrish, vasanthan, 1000);
    }
}