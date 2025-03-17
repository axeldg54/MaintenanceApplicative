package test.java.src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Events;
import src.event.BirthdayEvent;
import src.event.Event;
import src.event.attributes.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventsTest {

    private Events events;

    @BeforeEach
    void setUp() {
        events = new Events(new ArrayList<>());

        // Ajout de quelques événements avec des ID fictifs
        events.addEvent(new BirthdayEvent(
                new TitleEvent("Anniversaire Alice"),
                new OwnerEvent("Alice"),
                LocalDateTime.of(2025, 3, 17, 10, 0),
                new EventId(1)  // Ajout d'un ID fictif
        ));

        events.addEvent(new BirthdayEvent(
                new TitleEvent("Anniversaire Bob"),
                new OwnerEvent("Bob"),
                LocalDateTime.of(2025, 3, 18, 15, 0),
                new EventId(2)
        ));

        events.addEvent(new BirthdayEvent(
                new TitleEvent("Anniversaire Charlie"),
                new OwnerEvent("Charlie"),
                LocalDateTime.of(2025, 3, 19, 18, 0),
                new EventId(3)
        ));
    }

    @Test
    void testDeleteById_EventExists() {
        events.deleteById(2);

        // Vérifier que la taille a diminué
        assertEquals(2, events.size(), "L'événement avec ID 2 aurait dû être supprimé");

        // Vérifier que l'événement supprimé n'est plus dans la liste
        assertFalse(events.getEvents().stream().anyMatch(e -> e.getId().getId() == 2),
                "L'événement avec ID 2 ne devrait plus exister");
    }

    @Test
    void testDeleteById_EventDoesNotExist() {
        events.deleteById(99); // Suppression d'un ID inexistant

        // La taille ne devrait pas changer
        assertEquals(3, events.size(), "La taille ne devrait pas changer si l'ID n'existe pas");
    }

    @Test
    void testDeleteById_AllEventsRemoved() {
        events.deleteById(1);
        events.deleteById(2);
        events.deleteById(3);

        // La liste doit être vide
        assertTrue(events.getEvents().isEmpty(), "Tous les événements auraient dû être supprimés");
    }
}
