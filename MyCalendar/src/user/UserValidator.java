package src.user;

public interface UserValidator {
    boolean isValid(String username, String password);
}