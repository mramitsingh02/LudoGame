package com.ludo.controller;

import com.ludo.entities.Color;
import com.ludo.entities.Participant;
import com.ludo.entities.Participants;

public class LudoController {
    public static void main(String[] args) {
        Participants participants = new Participants(4);

        participants.add(new Participant("Amit", Color.RED));
        participants.add(new Participant("Tannu", Color.BLUE));
        participants.add(new Participant("Sanu", Color.YELLOW));
        participants.add(new Participant("Maa", Color.GREEN));

        for (int i = 0; i < 13; i++) {
            System.out.println(participants.nextParticipant().get());
        }

//        newPar.add();
    }
}
