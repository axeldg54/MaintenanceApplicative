package src.action;

import src.user.UserSession;

public class LogoutAction implements MenuAction {
    private final UserSession userSession;

    public LogoutAction(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void execute() {
        userSession.logout();
    }
}