package LLD2.adapter;

public class ICICIBankAPIAdapter implements BankAPIAdapter
{
    private ICICIBankAPI iciciBankAPI = new ICICIBankAPI();
    @Override
    public double checkBalance(User user)
    {
        return iciciBankAPI.checkBalance(generateUserToken(user));
    }

    @Override
    public int doTransactions(User sender, User receiver, double amount)
    {
        return iciciBankAPI.tranferMoney(generateUserToken(sender), generateUserToken(receiver), 1000);
    }

    @Override
    public boolean changePin(User user, int currPin, int newPin)
    {
        return iciciBankAPI.changePin(generateUserToken(user), newPin, currPin);
    }

    public String generateUserToken(User user)
    {
        return user.getUsername() +  user.getPassword();
    }
}
