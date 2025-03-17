package src.action.addevent;

import lombok.AllArgsConstructor;
import src.action.MenuAction;
import src.event.MeetingEvent;
import src.event.PersonalEvent;
import src.event.attributes.*;
import src.event.attributes.participant.Participant;
import src.manager.CalendarManager;
import src.user.UserSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
public class AddMeetingEventAction implements MenuAction {
    private CalendarManager calendar;
    private UserSession userSession;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        ParticipantsEvent participantsEvent = new ParticipantsEvent(new ArrayList<>());

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.print("Participants : " + participantsEvent);
            participantsEvent.addParticipant(new Participant(scanner.nextLine()));
        }

        MeetingEvent meetingEvent = new MeetingEvent(
                new TitleEvent(titre2),
                new OwnerEvent(userSession.getUsername()),
                LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2),
                new DurationEvent(duree2),
                new PlaceEvent(lieu),
                participantsEvent,
                new EventId(0));

        calendar.events.addEvent(meetingEvent);

        System.out.println("Événement ajouté.");
    }
}
