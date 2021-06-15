
interface UsersList {
    void addUser(String name, int balance);
    User retrieveId(int id);
    User retrieveIndex(int index);
    int userCount();
}
