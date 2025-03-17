package src.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import src.Events;
import src.event.attributes.DurationEvent;
import src.event.attributes.EventId;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public abstract class Event {
    public EventId id;
    public TitleEvent title;
    public OwnerEvent owner;
    public LocalDateTime startDate;
    public DurationEvent minutesDuration;

    public abstract String description();

    public abstract boolean isBetween(LocalDateTime debut, LocalDateTime fin);
}