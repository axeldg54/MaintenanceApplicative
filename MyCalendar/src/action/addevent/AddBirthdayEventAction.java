package src.action.addevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.event.MeetingEvent;
import src.event.attributes.*;
import src.event.attributes.participant.Participant;
import src.manager.CalendarManager;
import src.user.UserSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
public class AddBirthdayEventAction implements MenuAction {
    private CalendarManager calendar;
    private UserSession userSession;
    private Scanner scanner;

    @Override
    public void execute() {

    }
}
