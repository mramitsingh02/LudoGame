package com.ludo.entities;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testCreatePlayer() {
        Color color = Color.GREEN;
        String name = "Amit";
        final Player player = Player.builder().id(1).color(color).currentCell(color.getStartIndex()).name(name).build();
        assertEquals("Amit", player.getName());
        assertEquals(Color.GREEN, player.getColor());
        assertEquals(Color.GREEN.getStartIndex(), player.getColor().startCellIndex);
        assertEquals(Color.GREEN.getStartIndex(), player.getCurrentCell());
        assertEquals(1, player.getId());
        assertTrue(player.isNewPlayer());
        assertTrue(player.isOffTrack());
        assertFalse(player.isOnTrack());
        assertEquals("GREEN-Amit-1-1@13", player.toString());
        player.start();
        assertTrue(player.isOnTrack());
        player.setCurrentCell(Cell.clone(Color.RED.getStartIndex()));
        assertEquals(Color.RED.getStartIndex(), player.getCurrentCell());

        player.offTrack();
        assertTrue(player.isOffTrack());
        assertFalse(player.isOnTrack());
        assertEquals("GREEN-Amit-1-0@0", player.toString());
    }

    @Test
    public void testToString() {
        Color color = Color.GREEN;
        String name = "Amit";
        final Player player = Player.builder().id(1).color(color).currentCell(color.getStartIndex()).name(name).build();
        assertEquals("GREEN-Amit-1-1@13", player.toString());
        player.start();
        player.setCurrentCell(Cell.clone(Color.RED.getStartIndex()));
        assertEquals("GREEN-Amit-1-0@0", player.toString());
    }

    @Test
    public void testHashCode() {
        Color color = Color.GREEN;
        String name = "Amit";
        final Player player = Player.builder().id(1).color(color).currentCell(color.getStartIndex()).name(name).build();
        assertEquals("GREEN-Amit-1-1@13", player.toString());

        color = Color.RED;
        name = "Guddu";

        final Player player1 = Player.builder().id(2).color(color).currentCell(color.getStartIndex()).name(name).build();
        assertEquals("RED-Guddu-1-0@0", player1.toString());

        Set<Player> set = new HashSet<>();
        set.add(player);
        set.add(player1);
        assertEquals(2, set.size());
    }
}