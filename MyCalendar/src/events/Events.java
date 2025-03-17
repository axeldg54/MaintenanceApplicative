package src.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    public void removeEvent(int index) {
        events.remove(index);
    }

    public int size() {
        return events.size();
    }
}
