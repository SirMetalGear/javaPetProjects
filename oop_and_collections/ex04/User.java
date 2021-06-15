
public class User {
    private int             identifier;
    private String          name;
    private int             balance;
    TransactionsLinkedList transactions;
    public User(String n, int userBalance)
    {
        transactions = new TransactionsLinkedList();
        identifier = UserIdsGenerator.getInstance().GenerateNewId();
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
    public int getIdentifier() { return identifier; }
    public boolean setBalance(int amount) {
        if (balance + amount < 0)
            throw new IllegalTransactionException();
        this.balance += amount;
        return true;
    }
    public int transCount() { return transactions.size(); }
    public void addTransaction(Transaction obj) { transactions.addTransaction(obj); }
    public void delete(String id) { transactions.delete(id); }
    public Transaction[] toArray() { return transactions.toArray(); }
    public Transaction getTransaction(String id) { return transactions.findId(id); }
    public void info()
    {
        System.out.println(name + "'s balance: " + balance + "\nUser ID: " + identifier);
        System.out.println("Number of transactions: " + transactions.size());
        transactions.printId();
    }
}
