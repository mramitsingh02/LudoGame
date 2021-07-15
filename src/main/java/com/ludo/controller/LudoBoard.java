package com.ludo.controller;

import com.ludo.entities.*;

public class LudoBoard {
    private final Participants participants;
    private Participant headParticipant;
    private Participant currentParticipant;
    private final Dice dice;
    private HomeZone[] homeZones;
    private final Tracker tracker;
    private Rules rules;


    public LudoBoard(Participants participants) {
        this(participants, new Dice(), new Tracker(), new HomeZone[4]);
    }

    public LudoBoard(Participants participants, Dice dice, Tracker tracker, HomeZone[] homeZones) {
        if (participants.size() < 4) {
            ParticipantsFactory.addOtherParticipants(participants);
        }
        this.participants = participants;
        this.dice = dice;
        this.tracker = tracker;
        this.homeZones = homeZones;
        for (int i = 0; i < participants.size() ; i++) {
            var participant = participants.nextParticipant().get();
            if (participant.getColor().equals(Color.RED)) {
                headParticipant = participant;
            }
            homeZones[i] = new HomeZone(participant);
        }

    }

    public void print() {
        participants.forEach(System.out::println);
        System.out.println(dice);
        tracker.print();

    }

    public void play() throws InterruptedException {

        currentParticipant = headParticipant;
        int currentIndex = 0;
        while (true) {

            final HomeZone currentHomeZone = homeZones[nextIndex(currentIndex)];
            currentParticipant = currentHomeZone.currentParticipant();

            final int number = allTime6();
            if (number == 6) {
                System.out.println("Start By...." + currentParticipant.toString());
                Player player = currentHomeZone.getPlayer();
                tracker.onTrack(currentParticipant, player, number);
                //TimeUnit.SECONDS.sleep(1);
            } else {
                currentIndex++;
                //TimeUnit.SECONDS.sleep(1);
                System.out.println("running ");
            }


        }


    }



    private int nextIndex(int currentIndex) {
        return currentIndex % participants.size();
    }

    private int throwDisk() {
        return dice.roll();
    }

    private int allTime6() {
        return 6;
    }
}
