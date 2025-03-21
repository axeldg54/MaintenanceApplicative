package src.manager;

import src.Events;
import src.event.Event;
import src.event.PeriodicEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events(new ArrayList<>());
    }

    public List<Event> eventsBetweenPeriod(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events.getEvents()) {
            if (e.isBetween(debut, fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1;
        LocalDateTime fin2;
        if (e1 instanceof PeriodicEvent && e2 instanceof PeriodicEvent) {
            fin1 = e1.startDate.plusDays(((PeriodicEvent) e1).frequency.getDays());
            fin2 = e2.startDate.plusDays(((PeriodicEvent) e2).frequency.getDays());
        } else {
            fin1 = e1.startDate.plusMinutes(e1.minutesDuration.getMinutes());
            fin2 = e2.startDate.plusMinutes(e2.minutesDuration.getMinutes());
        }
        return e1.startDate.isBefore(fin2) && fin1.isAfter(e2.startDate);
    }
}