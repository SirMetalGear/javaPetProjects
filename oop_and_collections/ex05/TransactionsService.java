
import java.util.UUID;

public class TransactionsService {
    private UsersArrayList users;
    private TransactionsLinkedList unpaired;
    public TransactionsService() {
        users = new UsersArrayList();
        unpaired = new TransactionsLinkedList();
    }
    public void addUser(String name, int balance) {
        if (name == null || balance < 0)
        {
            System.out.println("Wrong parameters for user");
            return ;
        }
        users.addUser(name, balance);
    }
    public int getBalanceIndex(int userIndex) { return users.retrieveIndex(userIndex).getBalance(); }
    public int getBalanceId(int userId) { return users.retrieveId(userId).getBalance(); }
    public int getUserCount() { return users.userCount(); }
    public User getUser(int userId) { return users.retrieveId(userId); }
    public void newTransaction(int senderId, int recipientId, int amount)
    {
        if (amount <= 0)
        {
            System.out.println("Transaction failed");
            return ;
        }
        User recipient = users.retrieveId(recipientId);
        User sender = users.retrieveId(senderId);
        UUID transId = UUID.randomUUID();
        recipient.addTransaction(new Transaction(recipient, sender, amount, transId));
        sender.addTransaction(new Transaction(recipient, sender, -amount, transId));
    }
    public Transaction[] getTransfers(int userId) { return users.retrieveId(userId).toArray(); }
    public void deleteTransaction(int userId, String transactionId) {
        if (users.retrieveId(userId).getTransaction(transactionId) != null
                && unpaired.findId(transactionId) != null)
            unpaired.delete(transactionId);
        else
            unpaired.addTransaction(new Transaction(users.retrieveId(userId).getTransaction(transactionId)));
        users.retrieveId(userId).delete(transactionId);
    }
    public Transaction[] getUnpairedTransactions() { return unpaired.toArray();}

}
