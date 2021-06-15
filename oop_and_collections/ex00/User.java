public class User {
    private int     identifier;
    private String  name;
    private int     balance;
    User(int id, String n, int userBalance)
    {
        identifier = id;
        name = n;
        balance = userBalance;
    }
    public int getBalance()
    {
        return this.balance;
    }
    public String getName()
    {
        return name;
    }

    public boolean setBalance(int amount) {
        if (balance + amount < 0)
            return false;
        this.balance += amount;
        return true;
    }
    public void info()
    {
        System.out.println(name + "'s balance: " + balance + "\nUser ID: " + identifier);
    }
}
