
public class Program {
    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();
        service.addUser("User1", 1000);
        service.addUser("User2", 10000);
        service.newTransaction(0, 1, 200);
        service.newTransaction(0, 1, 200);
        service.newTransaction(0, 1, 200);
        String toDelete = service.getTransfers(0)[0].getId();
        String toDelete2 = service.getTransfers(0)[1].getId();
        System.out.println("to delete: " + toDelete);
        System.out.println("to delete2: " + toDelete2);
        service.deleteTransaction(0, toDelete);
        service.deleteTransaction(1, toDelete);
        service.deleteTransaction(0, toDelete2);
        Transaction[] unpaired = service.getUnpairedTransactions();
        if (unpaired != null) {
            System.out.println("length: " + unpaired.length);
            for (int i = 0; i < unpaired.length; i++)
                System.out.println("unpaired: " + unpaired[i].getId());
        }
    }
}
