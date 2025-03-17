package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class FrequencyEvent {
    private int days;

    public String toString() {
        return Integer.toString(days);
    }
}
