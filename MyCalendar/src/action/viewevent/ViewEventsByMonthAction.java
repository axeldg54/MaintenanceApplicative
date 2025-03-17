package src.action.viewevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.manager.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

import static src.action.viewevent.ViewEventsAction.afficherListe;

@AllArgsConstructor
public class ViewEventsByMonthAction implements MenuAction {
    private CalendarManager calendar;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherListe(calendar.eventsBetweenPeriod(debutMois, finMois));
    }
}
