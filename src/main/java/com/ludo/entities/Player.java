package com.ludo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private Color color;
    @FieldNameConstants.Exclude
    private boolean isOnTrack;
    private boolean isOnStamp;
    private Cell currentCell;


    @Override
    public String toString() {
        return color + "-" + name + "-" + id + "-" + currentCell;
    }

    @Override
    public int compareTo(Player player) {
        return color.compareTo(player.color) + Integer.valueOf(id).compareTo(player.id) + name.compareTo(player.name);
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isOnTrack() {
        return isOnTrack;
    }

    public Player onTrack() {
        isOnTrack = true;
        return this;
    }

    public Player onStamp() {
        isOnStamp = true;
        return this;
    }

    public Player offTrack() {
        isOnTrack = false;
        return this;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Player setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
        return this;
    }

    public boolean isNewPlayer() {
        return !isOnTrack || !currentCell.isStartCell;
    }

    public int getId() {
        return id;
    }

    public boolean isOffTrack() {
        return !isOnTrack;
    }

    public void start() {
        this.onTrack().onStamp();
    }
}

