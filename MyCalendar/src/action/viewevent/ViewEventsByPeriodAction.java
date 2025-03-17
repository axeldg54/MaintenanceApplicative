package src.action.viewevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.manager.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

import static src.action.viewevent.ViewEventsAction.afficherListe;

@AllArgsConstructor
public class ViewEventsByPeriodAction implements MenuAction {
    private CalendarManager calendar;
    private Scanner scanner;

    @Override
    public void execute() {

    }
}
