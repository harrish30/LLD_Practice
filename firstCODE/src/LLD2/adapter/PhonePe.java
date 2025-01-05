package LLD2.adapter;

public class PhonePe
{
    private BankAPIAdapter bankAPIAdapter;

    public PhonePe(BankAPIAdapter bankAPIAdapter)
    {
        this.bankAPIAdapter = new ICICIBankAPIAdapter();
    }

    public void checkBalance(User user)
    {
        double balance = bankAPIAdapter.checkBalance(user);
        System.out.println("Current Balance: " + balance);
    }
    public void doTransaction(User sender, User receiver, double amount)
    {
        if(bankAPIAdapter.checkBalance(sender) < amount)
        {
            System.out.println("Transaction Failed");
        }
        int status = bankAPIAdapter.doTransactions(sender, receiver, amount);
        switch(status)
        {
            case 1: System.out.println("Transaction Successful");
            break;
            case 0: System.out.println("Transaction Failure");
            break;
            default: System.out.println("Transaction In Progress");
            break;
        }
    }
}
