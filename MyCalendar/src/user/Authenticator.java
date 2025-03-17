package src.user;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Authenticator {
    private final Scanner scanner;
    private final List<UserValidator> validators;
    private HashMap<String, String> users = new HashMap<>();

    public Authenticator(Scanner scanner) {
        this.scanner = scanner;
        this.validators = List.of(new StaticUserValidator());
    }

    public UserSession authenticate() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        return validators.stream()
                .filter(validator -> validator.isValid(username, password))
                .findFirst()
                .map(validator -> new UserSession(username))
                .orElseGet(() -> {
                    System.out.println("Échec de l'authentification.");
                    return authenticate();
                });
    }

    public UserSession createUser() {
        String utilisateur;
        System.out.print("Nom d'utilisateur: ");
        utilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(motDePasse)) {
            users.put(utilisateur, motDePasse);
            return new UserSession(utilisateur);
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
            return createUser();
        }
    }
}