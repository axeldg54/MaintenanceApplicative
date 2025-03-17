package src.action.viewevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.manager.CalendarManager;

@AllArgsConstructor
public class ViewAllEventsAction implements MenuAction {
    private CalendarManager calendar;

    @Override
    public void execute() {
        calendar.events.printEvents();
    }
}
