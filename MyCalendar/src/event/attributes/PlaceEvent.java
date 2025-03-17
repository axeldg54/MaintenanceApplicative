package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PlaceEvent {
    private String place;

    public String toString() {
        return place;
    }
}