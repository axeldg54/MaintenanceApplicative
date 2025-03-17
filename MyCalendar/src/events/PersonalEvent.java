package src.events;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    public PersonalEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
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
