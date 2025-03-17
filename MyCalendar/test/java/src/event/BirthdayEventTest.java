package test.java.src.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.event.BirthdayEvent;
import src.event.attributes.EventId;
import src.event.attributes.OwnerEvent;
import src.event.attributes.TitleEvent;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayEventTest {
    private BirthdayEvent birthdayEvent;
    private LocalDateTime eventDate;

    @BeforeEach
    void setUp() {
        eventDate = LocalDateTime.of(2025, 3, 17, 15, 0);
        TitleEvent title = new TitleEvent("Anniversaire de Alice");
        OwnerEvent owner = new OwnerEvent("Alice");
        birthdayEvent = new BirthdayEvent(title, owner, eventDate, new EventId(0));
    }

    @Test
    void testBirthdayEventCreation() {
        assertEquals("Anniversaire de Alice", birthdayEvent.getTitle().toString());
        assertEquals("Alice", birthdayEvent.getOwner().toString());
        assertEquals(eventDate, birthdayEvent.getStartDate());
        assertEquals(0, birthdayEvent.getMinutesDuration().getMinutes());
    }

    @Test
    void testDescription() {
        String expectedDescription = "Anniversaire : Anniversaire de Alice à 2025-03-17T15:00";
        assertEquals(expectedDescription, birthdayEvent.description());
    }

    @Test
    void testIsBetween() {
        LocalDateTime start = LocalDateTime.of(2025, 3, 17, 14, 0);
        LocalDateTime end = LocalDateTime.of(2025, 3, 17, 16, 0);

        assertTrue(birthdayEvent.isBetween(start, end));

        LocalDateTime before = LocalDateTime.of(2025, 3, 17, 13, 59);
        LocalDateTime after = LocalDateTime.of(2025, 3, 17, 16, 1);

        assertFalse(birthdayEvent.isBetween(before, start));
        assertFalse(birthdayEvent.isBetween(end, after));
    }

    @Test
    void testIsBetweenExactBounds() {
        LocalDateTime exactStart = eventDate;
        LocalDateTime exactEnd = eventDate;

        assertTrue(birthdayEvent.isBetween(exactStart, exactEnd));
    }
}
