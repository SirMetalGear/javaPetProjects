
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
        }
        else {
            this.transferCategory = "OUTCOME";
            this.sender.setBalance(transferAmount);
        }
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
        if (transferAmount > 0)
        {
            System.out.print("From " + sender.getName() + "(id = " + sender.getIdentifier() + ") ");
            System.out.println(String.format("%+d", this.transferAmount) + " with id = " + identifier.toString());
        }
        else {
            System.out.print("To " + recipient.getName() + "(id = " + recipient.getIdentifier() + ") ");
            System.out.println(String.format("%+d", this.transferAmount) + " with id = " + identifier.toString());
        }
    }
    public void lost() {
        if (transferAmount < 0)
        {
            System.out.print(recipient.getName() + "(id = " + recipient.getIdentifier() + ") ");
            System.out.print("has an unacknowledged transfer id = " + identifier.toString());
            System.out.print(" from " + sender.getName() + "(id = " + sender.getIdentifier() + ") ");
            System.out.println("for " + transferAmount * -1);
        }
        else {
            System.out.print(sender.getName() + "(id = " + sender.getIdentifier() + ") ");
            System.out.print("has an unacknowledged transfer id = " + identifier.toString());
            System.out.print(" from " + recipient.getName() + "(id = " + recipient.getIdentifier() + ") ");
            System.out.println("for " + transferAmount * -1);
        }
    }
}
