package com.ludo.controller;

import com.ludo.entities.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class LudoBoard {
    private final Participants participants;
    private Participant headParticipant;
    private Participant currentParticipant;
    private final Dice dice;
    private HomeZone[] homeZones;
    private final Tracker tracker;
    private Rules rules = new Rules();


    public LudoBoard(Participants participants) {
        this(participants, new Dice(), new Tracker(), new HomeZone[4]);
        final RetryDiceRuleImpl rule = new RetryDiceRuleImpl();
        rule.setCondition(RuleUtils.is6Number, RuleUtils.diceMaxThresholdRich );
        rules.registerRule(rule);

    }



    private LudoBoard(Participants participants, Dice dice, Tracker tracker, HomeZone[] homeZones) {
        addMissingParticipant(participants);
        this.participants = participants;
        this.dice = dice;
        this.tracker = tracker;
        this.homeZones = homeZones;
        participantAssignToHomeZone();

    }

    private void addMissingParticipant(Participants participants) {
        if (participants.size() < participants.initialCapacity()) {
            ParticipantsFactory.addCrossParticipants(participants, participants.initialCapacity() - participants.size());
        }
    }


    public void play() throws InterruptedException {

        currentParticipant = headParticipant;
        int currentIndex = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            final HomeZone currentHomeZone = homeZones[nextIndex(currentIndex)];
            currentParticipant = currentHomeZone.currentParticipant();
//            int number = rollDiceByParticipantOrComputer(scanner);
            int number = allTime6();
            rules.setNumber(number);
            if (rules.isAllowed()) {
                System.out.println(">>>>>>>>" + currentParticipant.toString() + "<<<<<<<<");
                Player player = currentHomeZone.getPlayer();
                playerMoveOnTrack(number, player);
            } else {
                currentIndex++;
                Player player = currentHomeZone.getOnTrackPlayer();
                if (player == null) {
                    System.out.println(currentParticipant.readableName() + " skip chance. got <" + number + ">.");
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                playerMoveOnTrack(number, player);
            }
            TimeUnit.SECONDS.sleep(1);


        }


    }

    private void playerMoveOnTrack(int number, Player player) {
/*
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<Tracker> submit = executorService.submit(new TrackerPlayerCallable(tracker, player, number));
        try {
            final Tracker tracker = submit.get();



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
*/
        try {
            new TrackerPlayerCallable(tracker, player, number).call();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void participantAssignToHomeZone() {
        for (int i = 0; i < this.participants.size(); i++) {
            var participant = this.participants.nextParticipant().get();
            if (participant.getColor().equals(Color.RED)) {
                headParticipant = participant;
            }
            homeZones[i] = new HomeZone(participant);
        }
    }

    public void print() {
        Arrays.stream(homeZones).forEach(System.out::println);
//        participants.forEach(System.out::println);
        System.out.println(dice);
        tracker.print();

    }



    private int rollDiceByParticipantOrComputer(Scanner scanner) {
        int number = -1;

        if (currentParticipant.getUser().equals(User.HUMAN)) {
            System.out.print(currentParticipant.readableName() + " Please roll the dice:");
            while (!"r".equals(scanner.next())) ;
            number = currentParticipant.rollDice(dice);
        } else {
            number = currentParticipant.rollDice(dice);
        }
        return number;
    }

    private boolean isMaxNumberOfDice(int number) {
        return number == 6;
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
