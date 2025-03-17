package src.action.viewevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.manager.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

import static src.action.viewevent.ViewEventsAction.afficherListe;

@AllArgsConstructor
public class ViewEventsByDayAction implements MenuAction {
    private CalendarManager calendar;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        afficherListe(calendar.eventsBetweenPeriod(debutJour, finJour));
    }
}
