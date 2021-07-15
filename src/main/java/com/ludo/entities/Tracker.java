package com.ludo.entities;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class Tracker {
    private Path[] path;

    public Tracker() {
        path = new Path[4];
        for (int i = 0; i < 4; i++) {
            path[i] = new Path(i);
        }
    }

    public void print() {
        for (Path path : path) {
            System.out.println(path);
        }
    }

    public Path getPath(int index) {
        return path[index];
    }

    public void onTrack(Participant participant, Player currentParticipant, int number) {
        Path startPath = getPath(participant.getId());
        startPath.setPlayer(currentParticipant);
        startPath.start();


    }
}
