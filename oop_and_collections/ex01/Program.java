
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
    public static void main(String[] args) {
        User sender = newUser("Sanya", 100);
        User receiver = newUser("Dimon", 2);
        sender.info();
        receiver.info();
    }
}
