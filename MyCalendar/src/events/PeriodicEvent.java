package src.events;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {

    public int frequenceJours;

    public PeriodicEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);

        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime temp = this.dateDebut;
        return (!temp.isBefore(debut) && !temp.isAfter(fin)
                && !temp.plusDays(this.frequenceJours).isAfter(fin));
    }

}