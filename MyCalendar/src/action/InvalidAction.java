package src.action;

public class InvalidAction implements MenuAction {
    @Override
    public void execute() {
        System.out.println("Choix invalide.");
    }
}