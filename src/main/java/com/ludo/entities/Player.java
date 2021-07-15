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

    @Override
    public String toString() {
        return  color +"-" + name +"-" + id ;
    }

    @Override
    public int compareTo(Player player) {
        return color.compareTo(player.color) + Integer.valueOf(id).compareTo(player.id) + name.compareTo(player.name);
    }

    public boolean isOnTrack() {
        return isOnTrack;
    }

    public Player setOnTrack(boolean onTrack) {
        isOnTrack = onTrack;
        return this;
    }
}
