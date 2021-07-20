package com.ludo.controller;

import com.ludo.entities.Color;
import com.ludo.entities.Participant;
import com.ludo.entities.Participants;
import com.ludo.entities.UserType;

public class LudoDashBoardController {

    public static void main(String[] args) throws InterruptedException {
        Participants participants = new Participants(2);
        participants.add(Participant.builder().name("Amit").user(UserType.HUMAN).color(Color.RED).build());
//        participants.add(Participant.builder().name("Tannu").user(User.HUMAN).color(Color.BLUE).build());
        LudoBoard dashBoard= new LudoBoard(participants);
        dashBoard.print();
        dashBoard.play();


    }


}
