package src.events;

import java.time.LocalDateTime;

public class MeetingEvent extends Event {

    public String lieu;
    public String participants;

    public MeetingEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);

        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        return (!this.dateDebut.isBefore(debut) && !this.dateDebut.isAfter(fin));
    }
}
