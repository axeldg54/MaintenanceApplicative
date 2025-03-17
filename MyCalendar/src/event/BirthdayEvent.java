package src.event;

import lombok.Getter;
import src.event.attributes.DurationEvent;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;

import java.time.LocalDateTime;

@Getter
public class BirthdayEvent extends Event {
    public BirthdayEvent(TitleEvent title, OwnerEvent owner, LocalDateTime date) {
        super(title, owner, date, new DurationEvent(0));
    }

    @Override
    public String description() {
        return "Anniversaire : " + title + " à " + startDate.toString();
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        return (!this.startDate.isBefore(debut) && !this.startDate.isAfter(fin));
    }
}
