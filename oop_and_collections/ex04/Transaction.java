
import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private int transferAmount;
    public Transaction next;
    public Transaction prev;
    Transaction(User recipient, User sender, int transferAmount, UUID identifier) {
        next = null;
        prev = null;
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
        this.identifier = identifier;
        if (transferAmount > 0) {
            this.transferCategory = "INCOME";
            this.recipient.setBalance(transferAmount);
            System.out.print(recipient.getName() + " -> " + sender.getName());
        }
        else {
            this.transferCategory = "OUTCOME";
            this.sender.setBalance(transferAmount);
            System.out.print(sender.getName() + " -> " + recipient.getName());
        }
        System.out.print(", " + String.format("%+d", this.transferAmount));
        System.out.println(", " + this.transferCategory + ", transaction " + this.identifier.toString());
    }
    Transaction(Transaction obj)
    {
       this.identifier = obj.identifier;
       this.recipient = obj.recipient;
       this.sender = obj.sender;
       this.transferCategory = obj.transferCategory;
       this.transferAmount = obj.transferAmount;
    }

    public String getId() { return identifier.toString(); }

    public void info() {
        System.out.println("Transaction ID: " + identifier.toString());
        System.out.println("recipient: " + recipient.getName());
        System.out.println("sender: " + sender.getName());
        System.out.println("Category: " + transferCategory);
        System.out.println("Amount: " + String.format("%+d", this.transferAmount));
    }
}
