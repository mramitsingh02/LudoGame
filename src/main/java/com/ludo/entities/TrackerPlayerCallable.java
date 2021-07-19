package com.ludo.entities;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class TrackerPlayerCallable implements Callable<Tracker> {

    private final Tracker tracker;
    private final Player player;
    private final int diceNumber;


    @Override
    public Tracker call() throws Exception {

        if (player.isNewPlayer()) {
            onTrack(player, diceNumber);
        } else {
            moveForwardOnTrack(player, diceNumber);
        }


        return tracker;
    }


    public void onTrack(Player player, int number) {
        final Cell currentCell = player.getCurrentCell();
        currentCell.onStartCell();
        player.start();
        final Path path = tracker.getPath(player.getId());
        path.setPlayer(player);
        System.out.println(path);
        System.out.println("Start Player: " + player.toString());
    }

    public void moveForwardOnTrack(Player player, int number) {
        Path startPath = tracker.getPath(player.getId());
        startPath.setPlayer(player);
        startPath.moveBy(number);
        System.out.println(startPath);
    }

}
