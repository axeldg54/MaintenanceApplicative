package src.events;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {
    public PeriodicEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
