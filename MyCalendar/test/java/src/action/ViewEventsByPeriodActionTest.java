package test.java.src.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import src.action.viewevent.ViewEventsByPeriodAction;
import src.manager.CalendarManager;
import src.event.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class ViewEventsByPeriodActionTest {
    private CalendarManager calendar;
    private Scanner scanner;
    private ViewEventsByPeriodAction action;

    @BeforeEach
    void setUp() {
        calendar = mock(CalendarManager.class);
        scanner = mock(Scanner.class);
        action = new ViewEventsByPeriodAction(calendar, scanner);
    }

    @Test
    void testExecute_DisplaysEventsForGivenPeriod() {
        when(scanner.nextLine())
                .thenReturn("2025-03-17T10:00")
                .thenReturn("2025-03-18T18:00");

        List<Event> mockEvents = List.of(mock(Event.class), mock(Event.class));
        when(calendar.eventsBetweenPeriod(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(mockEvents);

        action.execute();

        verify(calendar, times(1)).eventsBetweenPeriod(
                LocalDateTime.parse("2025-03-17T10:00"),
                LocalDateTime.parse("2025-03-18T18:00")
        );
    }
}
