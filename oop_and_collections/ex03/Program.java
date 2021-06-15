import java.util.UUID;

public class Program {
    public static User newUser(String name, int balance)
    {
        if (name == null || balance < 0)
        {
            System.out.println("Wrong parameters for user");
            return null;
        }
        return new User(name, balance);
    }
    public static String newTransaction(User recipient, User sender, int amount)
    {
        if (recipient == null || sender == null || amount <= 0 && recipient.getBalance() - amount < 0)
        {
            System.out.println("Transaction failed");
            return null;
        }
        UUID transId = UUID.randomUUID();
        recipient.addTransaction(new Transaction(recipient, sender, -amount, transId));
        sender.addTransaction(new Transaction(recipient, sender, amount, transId));
        return transId.toString();
    }
    public static void main(String[] args) {
        User user1 = newUser("USER 1", 1000000);
        User user2 = newUser("USER 2", 2000000);
        String[] tids = new String[50];
        for (int i = 0; i < 50; i++)
            tids[i] = newTransaction(user1, user2, 50);
        System.out.println("-------------BEFORE DELETE------------");
        user1.info();
        System.out.println("--------------AFTER DELETE------------");
        for (int i = 0; i < 50; i++)
            user1.delete(tids[i]);
        user1.info();
    }
}
