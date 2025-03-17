package src;

import src.action.*;
import src.action.addevent.AddBirthdayEventAction;
import src.action.addevent.AddMeetingEventAction;
import src.action.addevent.AddPeriodicEventAction;
import src.action.addevent.AddPersonalEventAction;
import src.action.viewevent.ViewEventsAction;
import src.manager.CalendarManager;
import src.user.UserSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private final CalendarManager calendar;
    private final UserSession userSession;
    private final Map<String, MenuAction> actions;

    public MainMenu(Scanner scanner, CalendarManager calendar, UserSession userSession) {
        this.scanner = scanner;
        this.calendar = calendar;
        this.userSession = userSession;
        this.actions = new HashMap<>();

        actions.put("1", new ViewEventsAction(calendar));
        actions.put("2", new AddPersonalEventAction(calendar, userSession, scanner));
        actions.put("3", new AddMeetingEventAction(calendar, userSession, scanner));
        actions.put("4", new AddPeriodicEventAction(calendar, userSession, scanner));
        actions.put("5", new AddBirthdayEventAction(calendar, userSession, scanner));
        actions.put("6", new LogoutAction(userSession));
    }

    public void display() {
        System.out.println("\nBonjour, " + userSession.getUsername());
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Ajouter un anniversaire");
        System.out.println("6 - Se déconnecter");
        System.out.print("Votre choix : ");

        actions.getOrDefault(scanner.nextLine(), new InvalidAction()).execute();
    }
}