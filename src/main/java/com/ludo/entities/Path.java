package com.ludo.entities;

import lombok.ToString;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@ToString
public class Path {
    private int zoneId;
    private Queue<Player> players = new LinkedBlockingDeque<>();
    private Cell[] cell;
    Map<Player, Cell> playerCellMap = new HashMap<>();

    public Path(int zoneId) {
        this.zoneId = zoneId;
        cell = new Cell[13];
        for (int i = 0; i < 13; i++) {
            Cell subcell;
            if (i == 7) {
                subcell = new Cell(zoneId, i, true);
            } else {
                subcell = new Cell(zoneId, i);

            }
            cell[i] = subcell;
        }

    }

    @Override
    public String toString() {
        return "Path{" +
                "zoneId=" + zoneId +
                ", players=" + players +
                ", cell=" + Arrays.toString(cell) +
                ", playerCellMap=" + playerCellMap +
                '}';
    }

    public int getZoneId() {
        return zoneId;
    }

    public void start() {
//        final Cell cell = playerCellMap.get(player);
     //   cell.isStartCell() ? cell.start(): cell.runBy(number);

    }

    public Player setPlayer(Player player) {
        this.players.add(player);
        return player;
    }

    public void move() {

    }

    public void moveBy(int number) {
        final Player player = players.remove();
        final Cell cell = player.getCurrentCell();
        cell.row = cell.getRow();
        cell.column +=  number;

    }
}