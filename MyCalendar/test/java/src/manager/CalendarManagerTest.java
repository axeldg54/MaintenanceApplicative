package test.java.src.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.event.Event;
import src.event.MeetingEvent;
import src.event.PeriodicEvent;
import src.event.PersonalEvent;
import src.event.attributes.*;
import src.event.attributes.participant.Participant;
import src.manager.CalendarManager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventConflictCheckerTest {

    private CalendarManager calendar;
    private Event event1;
    private Event event2;
    private Event periodicEvent1;
    private Event periodicEvent2;

    @BeforeEach
    void setUp() {
        calendar = new CalendarManager();

        event1 = new PersonalEvent(
                new TitleEvent("Réunion"),
                new OwnerEvent("Alice"),
                LocalDateTime.of(2025, 3, 17, 10, 0),
                new DurationEvent(60),
                new EventId(0)
        );

        event2 = new MeetingEvent(
                new TitleEvent("Entretien"),
                new OwnerEvent("Bob"),
                LocalDateTime.of(2025, 3, 17, 10, 30),
                new DurationEvent(60),
                new PlaceEvent("Salle A"),
                new ParticipantsEvent(new ArrayList<>()),
                new EventId(0)
        );

        periodicEvent1 = new PeriodicEvent(
                new TitleEvent("Yoga"),
                new OwnerEvent("Charlie"),
                LocalDateTime.of(2025, 3, 17, 9, 0),
                new DurationEvent(30),
                new FrequencyEvent(7),
                new EventId(0)
        );

        periodicEvent2 = new PeriodicEvent(
                new TitleEvent("Gym"),
                new OwnerEvent("David"),
                LocalDateTime.of(2025, 3, 18, 9, 0),
                new DurationEvent(45),
                new FrequencyEvent(7),
                new EventId(0)
        );
    }

    @Test
    void testConflitEntreDeuxEvenementsSimples() {
        assertTrue(calendar.conflit(event1, event2), "Les événements doivent être en conflit");
    }

    @Test
    void testAucunConflitEntreDeuxEvenementsSimples() {
        Event event3 = new PersonalEvent(
                new TitleEvent("Pause"),
                new OwnerEvent("Eve"),
                LocalDateTime.of(2025, 3, 17, 12, 0),
                new DurationEvent(30),
                new EventId(0)
        );

        assertFalse(calendar.conflit(event1, event3), "Les événements ne doivent pas être en conflit");
    }

    @Test
    void testPeriodicEventNeCausePasDeConflit() {
        assertFalse(calendar.conflit(event1, periodicEvent1), "Les événements périodiques ne doivent pas être considérés en conflit");
    }

    @Test
    void testConflitEntreDeuxPeriodicEvents() {
        assertTrue(calendar.conflit(periodicEvent1, periodicEvent2), "Les événements périodiques doivent être en conflit s'ils se chevauchent");
    }
}
