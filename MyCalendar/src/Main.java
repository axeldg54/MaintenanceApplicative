package src;

import src.manager.CalendarManager;
import src.user.Authenticator;
import src.user.UserSession;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        Authenticator authenticator = new Authenticator(scanner);

        boolean running = true;
        while (running) {
            System.out.println("  _____         _                   _                __  __");
            System.out.println(" / ____|       | |                 | |              |  \\/  |");
            System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
            System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
            System.out.println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
            System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
            System.out.println("                                                                                   __/ |");
            System.out.println("                                                                                  |___/");
            System.out.println("1 - Se connecter");
            System.out.println("2 - Créer un compte");
            System.out.print("Choix : ");

            HashMap<String, Consumer<Void>> actions = new HashMap<>();

            actions.put("1", (Void v) -> {
                UserSession session = authenticator.authenticate();
                if (session != null && session.isActive()) {
                    System.out.println("Bienvenue, " + session.getUsername());
                    while (session.isActive()) {
                        new MainMenu(scanner, calendar, session).display();
                    }
                } else {
                    System.out.println("Échec de la connexion. Veuillez réessayer.");
                }
            });

            actions.put("2", (Void v) -> {
                UserSession session = authenticator.createUser();
                if (session != null && session.isActive()) {
                    System.out.println("Bienvenue, " + session.getUsername());
                    while (session.isActive()) {
                        new MainMenu(scanner, calendar, session).display();
                    }
                }
            });

            String choice = scanner.nextLine();
            actions.getOrDefault(choice, (v) -> System.out.println("Choix invalide.")).accept(null);

            // Vous pouvez ajouter un mécanisme pour arrêter l'application si nécessaire
            System.out.print("Voulez-vous quitter ? (O/N) : ");
            String exitChoice = scanner.nextLine();
            if (exitChoice.equalsIgnoreCase("O")) {
                running = false;
            }
        }
    }
}
