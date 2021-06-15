
public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException() {
        super("The transaction was not found");
    }
}
