package src.event;

import src.event.attributes.*;

import java.time.LocalDateTime;

public class MeetingEvent extends Event {

    public PlaceEvent place;
    public ParticipantsEvent participants;

    public MeetingEvent(TitleEvent title, OwnerEvent owner, LocalDateTime dateDebut, DurationEvent minutesDuration, PlaceEvent place, ParticipantsEvent participants) {
        super(title, owner, dateDebut, minutesDuration);

        this.place = place;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + place + " avec " + participants;
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        return (!this.startDate.isBefore(debut) && !this.startDate.isAfter(fin));
    }
}
