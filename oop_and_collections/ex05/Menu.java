
import java.util.Scanner;

public class Menu {
    private TransactionsService serv;
    private Scanner in;
    Menu() {
        serv = new TransactionsService();
        in = new Scanner(System.in);
    }
    private void printMenu()
    {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        System.out.println("5. DEV - remove a transfer by ID");
        System.out.println("6. DEV - check transfer validity");
        System.out.println("7. Finish execution");
    }
    private void addUser() {
        System.out.println("Enter a user name and a balance");
        String userInput = in.nextLine();
        String[] parsed = userInput.split(" ");
        if (parsed.length == 2)
        {
            Scanner parser = new Scanner(parsed[1]);
            if (parser.hasNextInt() == true) {
                serv.addUser(parsed[0], parser.nextInt());
                parser.close();
                return;
            }
            parser.close();
        }
        System.out.println("Wrong parameters for user");
        return;
    }
    private void showBalance()
    {
        System.out.println("Enter a user ID");
        String userInput = in.nextLine();
        try {
            User user = serv.getUser(Integer.parseInt(userInput));
            System.out.println(user.getName() + " - " + user.getBalance());
        }
        catch (Exception e)
        {
            System.out.println("User has not found");
        }
    }
    private void transfer()
    {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        String userInput = in.nextLine();
        Scanner parser = new Scanner(userInput);
        try
        {
            serv.newTransaction(parser.nextInt(), parser.nextInt(), parser.nextInt());
            System.out.println("The transfer is completed");
        }
        catch (Exception e)
        {
            System.out.println("Transaction failed");
        }
        parser.close();
    }
    private void showTransaction()
    {
        System.out.println("Enter a user ID");
        String userInput = in.nextLine();
        try
        {
            serv.getUser(Integer.parseInt(userInput)).info();
        }
        catch (Exception e)
        {
            System.out.println("User has not found");
        }
    }
    private void removeTransfer()
    {
        System.out.println("Enter a user ID and a transfer ID");
        String userInput = in.nextLine();
        String[] parsed = userInput.split(" ");
        if (parsed.length != 2)
        {
            System.out.println("Wrong parameters");
            return;
        }
        try
        {
            serv.deleteTransaction(Integer.parseInt(parsed[0]), parsed[1]);
            System.out.println("Transfer removed");
        }
        catch (Exception e)
        {
            System.out.println("Wrong parameters");
        }
    }
    private void transferValidity()
    {
        Transaction[] unpaired = serv.getUnpairedTransactions();
        System.out.println("Check results:");
        if (unpaired != null)
        {
            for (int i = 0; i < unpaired.length; i++)
            {
                unpaired[i].lost();
            }
        }
    }
    public void inputParse()
    {
        String userInput;
        printMenu();
        while ((userInput = in.nextLine()) != null
                && (userInput.equals("7") != true))
        {
            if (userInput.equals("1"))
                addUser();
            else if (userInput.equals("2"))
                showBalance();
            else if (userInput.equals("3"))
                transfer();
            else if (userInput.equals("4"))
                showTransaction();
            else if (userInput.equals("5"))
                removeTransfer();
            else if (userInput.equals("6"))
                transferValidity();
            else
                System.out.println("Wrong input");
            System.out.println("---------------------------------------------------------");
            printMenu();
        }
        in.close();
    }

}
