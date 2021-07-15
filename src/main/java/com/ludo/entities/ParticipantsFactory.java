package com.ludo.entities;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsFactory {

    public static Participants addOtherParticipants(Participants participants) {

        List<Color> list = participants.stream().map(Participant::getColor).collect(Collectors.toList());
        for (Color color : Color.values()) {
            if (!list.contains(color) && !Color.NONE.equals(color) ) {
                participants.add(Participant.builder().color(color).user(User.COMPUTER).build());
            }
        }
        return participants;
    }

}
