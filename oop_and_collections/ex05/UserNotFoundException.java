
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("The user was not found");
    }
}
