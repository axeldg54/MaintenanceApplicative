package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class TitleEvent {
    private String title;

    public String toString() {
        return title;
    }
}