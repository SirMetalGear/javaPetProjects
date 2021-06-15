import java.util.UUID;

public class Program {
    private static int id = 0;
    public static User newUser(String name, int balance)
    {
        if (name == null || balance < 0)
        {
            System.out.println("Wrong parameters for user");
            return null;
        }
        return new User(id++, name, balance);
    }
    public static void newTransaction(User sender, User getter, int amount)
    {
        if (sender == null || getter == null || amount <= 0 && sender.getBalance() - amount < 0)
        {
            System.out.println("Transaction failed");
            return ;
        }
        UUID transId = UUID.randomUUID();
        new Transaction(sender, getter, -amount, transId);
        new Transaction(getter, sender, amount, transId);
        sender.info();
        getter.info();
    }
    public static void main(String[] args) {
        User sender = newUser("Sanya", 100);
        User receiver = newUser("Dimon", 2);
        newTransaction(sender, receiver, 20);
    }
}
