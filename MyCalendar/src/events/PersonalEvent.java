package src.events;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    public PersonalEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        return (!this.dateDebut.isBefore(debut) && !this.dateDebut.isAfter(fin));
    }
}
