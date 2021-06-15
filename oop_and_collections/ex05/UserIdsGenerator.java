
public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int id = 1;

    private UserIdsGenerator() {}

    public int GenerateNewId() {
        return id++;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
}
