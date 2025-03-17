package src.action.addevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.event.PeriodicEvent;
import src.event.PersonalEvent;
import src.event.attributes.DurationEvent;
import src.event.attributes.FrequencyEvent;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;
import src.manager.CalendarManager;
import src.user.UserSession;

import java.time.LocalDateTime;
import java.util.Scanner;

@AllArgsConstructor
public class AddPeriodicEventAction implements MenuAction {
    private CalendarManager calendar;
    private UserSession userSession;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        PeriodicEvent periodicEvent = new PeriodicEvent(
                new TitleEvent(titre3),
                new OwnerEvent(userSession.getUsername()),
                LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3),
                new DurationEvent(0),
                new FrequencyEvent(frequence));

        calendar.events.addEvent(periodicEvent);

        System.out.println("Événement ajouté.");
    }
}
