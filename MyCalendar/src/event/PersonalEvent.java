package src.event;

import src.event.attributes.DurationEvent;
import src.event.attributes.EventId;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    public PersonalEvent(TitleEvent title, OwnerEvent owner, LocalDateTime dateDebut, DurationEvent minutesDuration, EventId id) {
        super(id, title, owner, dateDebut, minutesDuration);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + startDate.toString();
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        return (!this.startDate.isBefore(debut) && !this.startDate.isAfter(fin));
    }
}
