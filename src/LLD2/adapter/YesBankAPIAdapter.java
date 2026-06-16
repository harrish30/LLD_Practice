package LLD2.adapter;

public class YesBankAPIAdapter implements BankAPIAdapter
{
    private YesBankAPI yesBankAPI = new YesBankAPI();
    @Override
    public double checkBalance(User user)
    {
        return (double) yesBankAPI.getBalance(user.getUsername(), user.getPassword());
    }

    @Override
    public int doTransactions(User sender, User receiver, double amount)
    {
        char result = yesBankAPI.doTransaction(sender.getUsername(), receiver.getUsername(), sender.getPassword(), amount);
        if(result == 'y')
        {
            return 1;
        }
        else if (result == 'n')
        {
            return 0;
        }
        return 2;
    }

    @Override
    public boolean changePin(User user, int currPin, int newPin)
    {
        return yesBankAPI.changePin(user.getUsername(), user.getPassword(), currPin, newPin);
    }
}
