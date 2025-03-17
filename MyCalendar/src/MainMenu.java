package src;

import src.action.*;
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
        actions.put("2", new AddEventAction(calendar, scanner, userSession));
        actions.put("3", new LogoutAction(userSession));
    }

    public void display() {
        System.out.println("\nBonjour, " + userSession.getUsername());
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un événement");
        System.out.println("3 - Se déconnecter");
        System.out.print("Votre choix : ");

        actions.getOrDefault(scanner.nextLine(), new InvalidAction()).execute();
    }
}