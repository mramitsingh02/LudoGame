package com.ludo.entities;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ToString
public class HomeZone {
    private Participant participant;
    private boolean isInHomeZone;
    private final Color color;
    private HomeZone nextHomeZone;
    private List<Player> playerOnTrack = new ArrayList<>();

    public HomeZone(Participant participant) {
        this.participant = participant;
        this.isInHomeZone = true;
        this.color = participant.getColor();
    }

    public HomeZone setNextHomeZone(HomeZone nextHomeZone) {
        this.nextHomeZone = nextHomeZone;
        return this;
    }

    public Participant currentParticipant() {
        return participant;
    }

    public void onTrackPlayer(Player player) {
        playerOnTrack.add(player);
    }

    public boolean hasNoPlayerOnTrack() {
        return playerOnTrack.isEmpty();
    }

    public boolean hasSinglePlayerOnTrack() {
        return playerOnTrack.size() == 1;
    }


    public Player getPlayer() {
        Player player;
        if (hasNoPlayerOnTrack()) {
            player = participant.getPlayer();
            setOnTrack(player);
        } else {
            List<Player> allPlayerByParticipant = new ArrayList<>();
            allPlayerByParticipant.addAll(playerOnTrack);
            allPlayerByParticipant.addAll(participant.getOffTrackPlayers());
            final int index = chosePlayer(allPlayerByParticipant);
            player = onTrackAndOffTrackPlayer(index);
            setOnTrack(player);
            if (!playerOnTrack.contains(player)) {
                playerOnTrack.add(player);
            }

        }
        return player;
    }

    private int chosePlayer(List<Player> allPlayerByParticipant) {
        for (Player player1 : allPlayerByParticipant) {
            if (player1.isOnTrack()) {
                System.out.println(player1 + " is on Track.");
            } else {
                System.out.println(player1 + " is not on Track.");
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Player To run On Track: ");
        final int index = scanner.nextInt();
        return index;
    }

    private Player onTrackAndOffTrackPlayer(int index) {
        Player player;

        try {
            player = playerOnTrack.get(index);
        } catch (IndexOutOfBoundsException e) {
            player = participant.getPlayerSet().remove();
        }

        return player;
    }

    private Player onTrackPlayer(int index) {
        Player player;

        try {
            player = playerOnTrack.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

        return player;
    }


    private void setOnTrack(Player player) {
        playerOnTrack.add(player);
    }

    public Player getOnTrackPlayer() {
        Player player;
        if (playerOnTrack.isEmpty()) {
            return null;
        }
        if (hasSinglePlayerOnTrack()) {
            player = playerOnTrack.get(0);
        } else {
            final int index = chosePlayer(playerOnTrack);
            player = onTrackPlayer(index);
        }
        return player;
    }
}
