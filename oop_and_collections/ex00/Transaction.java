import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private int transferAmount;
    Transaction(User recipient, User sender, int transferAmount, UUID identifier) {
        this.recipient = recipient;
        this.sender = sender;
        if (transferAmount > 0)
            this.transferCategory = "INCOME";
        else
            this.transferCategory = "OUTCOME";
        this.transferAmount = transferAmount;
        this.identifier = identifier;
        this.recipient.setBalance(transferAmount);
        System.out.print(recipient.getName() + " -> " + sender.getName() + ", " + String.format("%+d" ,transferAmount) + ", ");
        System.out.println(this.transferCategory + ", transaction " + identifier);
    }
}
