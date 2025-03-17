package src.action.viewevent;

import src.action.InvalidAction;
import src.action.MenuAction;
import src.event.Event;
import src.manager.CalendarManager;

import java.util.*;

public class ViewEventsAction implements MenuAction {
    private final Scanner scanner;
    private final Map<String, MenuAction> actions;

    public ViewEventsAction(CalendarManager calendar) {
        this.actions = new HashMap<>();
        this.scanner = new Scanner(System.in);

        actions.put("1", new ViewAllEventsAction(calendar));
        actions.put("2", new ViewEventsByMonthAction(calendar, scanner));
        actions.put("3", new ViewEventsByWeekAction(calendar, scanner));
        actions.put("4", new ViewEventsByDayAction(calendar, scanner));
    }

    @Override
    public void execute() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        actions.getOrDefault(scanner.nextLine(), new InvalidAction()).execute();
    }

    public static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }
}
