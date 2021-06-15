
public class Program {
    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();
        users.addUser("Bruce", 100000000);
        users.addUser("Batman", 100000000);
        String[] names = new String[] {"Wayne", "Damon", "Moron", "Lorein",
                "Scatman", "Billie Jean", "Michael", "Jackson", "Moby Dick", "John Doe", "Harry", "Potter"};
        int money = 1312;
        for (int i = 0; i < 12; i++) {
            money += i + 13 * 29 / (2 + i) + 312;
            users.addUser(names[i], money);
        }
        for (int i = 0; i < users.userCount(); i++)
            users.retrieveIndex(i).info();
//        users.retrieveId(12312);
    }
}
