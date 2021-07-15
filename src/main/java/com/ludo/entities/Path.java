package com.ludo.entities;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Path {
    private int zoneId;
    private Player player;
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

    public void start() {
        final Cell cell = playerCellMap.get(player);
     //   cell.isStartCell() ? cell.start(): cell.runBy(number);

    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}