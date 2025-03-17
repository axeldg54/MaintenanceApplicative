package src.action.viewevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.manager.CalendarManager;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

import static src.action.viewevent.ViewEventsAction.afficherListe;

@AllArgsConstructor
public class ViewEventsByWeekAction implements MenuAction {
    private CalendarManager calendar;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        afficherListe(calendar.eventsBetweenPeriod(debutSemaine, finSemaine));
    }
}
