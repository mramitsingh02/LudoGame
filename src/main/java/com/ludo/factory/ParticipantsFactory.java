package com.ludo.factory;

import com.ludo.entities.Color;
import com.ludo.entities.Participant;
import com.ludo.entities.Participants;
import com.ludo.entities.UserType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParticipantsFactory {

    public static Participants addOtherParticipants(Participants participants, int missingNoOfPayer) {

        List<Color> list = participants.stream().map(Participant::getColor).collect(Collectors.toList());
        for (Color color : Color.values()) {
            if (!list.contains(color) && !Color.NONE.equals(color) && missingNoOfPayer > 0) {
                participants.add(Participant.builder().color(color).user(UserType.COMPUTER).build());
                missingNoOfPayer--;
            }
        }
        return participants;
    }

    public static Participants addCrossParticipants(Participants participants, int missingNoOfPayer) {

        if (participants.size() == 1 && missingNoOfPayer == 1) {
            final Optional<Participant> participant = participants.nextParticipant();
            final int row = participant.get().getColor().getStartIndex().row;

            var j = (row + 2) % Color.values().length;

            Color nextParticipantColor;
            for (Color color1 : Color.values())
                if (color1.getStartIndex().row == j) {
                    nextParticipantColor = color1;
                    participants.add(Participant.builder().color(nextParticipantColor).user(UserType.COMPUTER).build());
                    break;
                }

        }
        return participants;
    }


}
