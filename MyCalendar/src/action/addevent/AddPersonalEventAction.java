package src.action.addevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.event.PersonalEvent;
import src.event.attributes.DurationEvent;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;
import src.manager.CalendarManager;
import src.user.UserSession;

import java.time.LocalDateTime;
import java.util.Scanner;

@AllArgsConstructor
public class AddPersonalEventAction implements MenuAction {
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
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        PersonalEvent personalEvent = new PersonalEvent(
                new TitleEvent(titre),
                new OwnerEvent(userSession.getUsername()),
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute),
                new DurationEvent(duree));

        calendar.events.addEvent(personalEvent);

        System.out.println("Événement ajouté.");
    }
}
