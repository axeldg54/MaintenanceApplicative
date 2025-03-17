package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DurationEvent {
    private int minutes;

    public String toString() {
        return Integer.toString(minutes);
    }
}