
public class UsersArrayList implements UsersList {
    private User[] userArray;
    private int capacity;
    private int size;
    public UsersArrayList() {
        capacity = 10;
        size = 0;
        userArray = new User[capacity];
    }
    public void addUser(String name, int balance) {
        if (name == null || balance < 0)
        {
            System.out.println("Wrong parameters for user");
            return;
        }
        if (size + 1 > capacity)
        {
            capacity *= 2;
            User[] newArr = new User[capacity];
            for (int i = 0; i < size; i++)
                newArr[i] = userArray[i];
            userArray = newArr;
        }
        userArray[size] = new User(name, balance);
        size++;
    }
    public User retrieveId(int id) {
        for (int i = 0; i < size; i++)
            if (id == userArray[i].getIdentifier())
                return userArray[i];
        throw new UserNotFoundException();
    }
    public User retrieveIndex(int index) {
        if (index < 0 || index >= size)
            throw new UserNotFoundException();
        return userArray[index];
    }
    public int userCount() { return size; }
}
