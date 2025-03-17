package src.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public abstract class Event {
    public String title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    public int dureeMinutes;

    public abstract String description();

    public abstract boolean isBetween(LocalDateTime debut, LocalDateTime fin);
}