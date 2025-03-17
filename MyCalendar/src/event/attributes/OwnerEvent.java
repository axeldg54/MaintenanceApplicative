package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class OwnerEvent {
    private String owner;

    public String toString() {
        return owner;
    }
}