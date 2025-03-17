package src.action;

import src.manager.CalendarManager;
import src.user.UserSession;

import java.util.Scanner;

public class AddEventAction implements MenuAction {
    private final CalendarManager calendar;
    private final Scanner scanner;
    private final UserSession userSession;

    public AddEventAction(CalendarManager calendar, Scanner scanner, UserSession userSession) {
        this.calendar = calendar;
        this.scanner = scanner;
        this.userSession = userSession;
    }

    @Override
    public void execute() {
//        calendar.addEvent(scanner, userSession);
    }
}