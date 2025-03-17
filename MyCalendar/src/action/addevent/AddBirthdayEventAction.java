package src.action.addevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.event.BirthdayEvent;
import src.event.MeetingEvent;
import src.event.PersonalEvent;
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
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        BirthdayEvent birthdayEvent = new BirthdayEvent(
                new TitleEvent(titre),
                new OwnerEvent(userSession.getUsername()),
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute));

        calendar.events.addEvent(birthdayEvent);

        System.out.println("Événement ajouté.");
    }
}
