package LLD2.adapter;

public interface BankAPIAdapter
{
    public double checkBalance(User user);
    public int doTransactions(User sender, User receiver, double amount);
    public boolean changePin(User user, int currPin, int newPin);
}
