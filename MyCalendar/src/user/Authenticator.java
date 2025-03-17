package src.user;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Authenticator {
    private final Scanner scanner;
    @Getter
    private final HashMap<String, String> users;

    public Authenticator(Scanner scanner) {
        this.scanner = scanner;
        this.users = new HashMap<>();
        users.put("Root", "Chat");
        users.put("Pierre", "KiRouhl");
    }

    public UserSession authenticate() {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            return new UserSession(username);
        }
        return null;
    }

    public UserSession createUser() {
        System.out.print("Nom d'utilisateur: ");
        String utilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");

        if (scanner.nextLine().equals(motDePasse)) {
            users.put(utilisateur, motDePasse);
            return new UserSession(utilisateur);
        } else {
            System.out.println("Les mots de passe ne correspondent pas...");
            return createUser();
        }
    }
}
