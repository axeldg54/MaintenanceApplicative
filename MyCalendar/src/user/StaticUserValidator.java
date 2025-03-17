package src.user;

public class StaticUserValidator implements UserValidator {
    @Override
    public boolean isValid(String username, String password) {
        return ("Roger".equals(username) && "Chat".equals(password)) ||
                ("Pierre".equals(username) && "KiRouhl".equals(password));
    }
}