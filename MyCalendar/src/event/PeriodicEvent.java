package src.event;

import src.event.attributes.*;

import java.time.LocalDateTime;

public class PeriodicEvent extends Event {

    public FrequencyEvent frequency;

    public PeriodicEvent(TitleEvent title, OwnerEvent owner, LocalDateTime dateDebut, DurationEvent minutesDuration, FrequencyEvent frequency, EventId id) {
        super(id, title, owner, dateDebut, minutesDuration);

        this.frequency = frequency;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequency + " jours";
    }

    @Override
    public boolean isBetween(LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime temp = this.startDate;
        return (!temp.isBefore(debut) && !temp.isAfter(fin)
                && !temp.plusDays(this.frequency.getDays()).isAfter(fin));
    }

}