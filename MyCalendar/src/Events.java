package src;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import src.event.Event;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Events {
    ArrayList<Event> events;

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEvent(int index) {
        return events.get(index);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public int size() {
        return events.size();
    }

    public void printEvents() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}
