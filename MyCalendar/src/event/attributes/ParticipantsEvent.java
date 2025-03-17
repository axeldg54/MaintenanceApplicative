package src.event.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import src.event.attributes.participant.Participant;

import java.util.ArrayList;

@AllArgsConstructor
@Setter
@Getter
public class ParticipantsEvent {
    private ArrayList<Participant> participants;

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public Participant getParticipant(int index) {
        return participants.get(index);
    }

    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public int size() {
        return participants.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Participant p : participants) {
            result.append(p).append(", ");
        }
        return result.toString();
    }
}
