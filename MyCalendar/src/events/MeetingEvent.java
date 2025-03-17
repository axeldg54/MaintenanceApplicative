package src.events;

import java.time.LocalDateTime;

public class MeetingEvent extends Event {
    public MeetingEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
