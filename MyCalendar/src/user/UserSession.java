package src.user;

import lombok.Getter;

@Getter
public class UserSession {
    private final String username;
    private boolean active;

    public UserSession(String username) {
        this.username = username;
        this.active = true;
    }

    public void logout() {
        this.active = false;
    }
}
