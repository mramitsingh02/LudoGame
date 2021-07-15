package com.ludo.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test
    public void createParticipant() {
        Participant participant = new Participant("AB", Color.RED);
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.RED);
        assertEquals(participant.getName(), "AB");
        assertEquals(participant.getUser(), User.COMPUTER);
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant2() {
        Participant participant = new Participant(Color.BLUE, User.HUMAN);
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.BLUE);
        assertEquals(participant.getUser(), User.HUMAN);
        assertEquals(participant.getName(), "Unknown");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant3() {
        Participant participant = new Participant("Jone", Color.GREEN, User.HUMAN);
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.GREEN);
        assertEquals(participant.getUser(), User.HUMAN);
        assertEquals(participant.getName(), "Jone");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant4() {
        Participant participant = Participant.builder().build();
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.NONE);
        assertEquals(participant.getUser(), User.COMPUTER);
        assertEquals(participant.getName(), "Unknown");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant5() {
        Participant participant = Participant.builder().name("Jone").build();
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.NONE);
        assertEquals(participant.getUser(), User.COMPUTER);
        assertEquals(participant.getName(), "Jone");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant6() {
        Participant participant = Participant.builder().name("Jone").color(Color.GREEN).build();
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.GREEN);
        assertEquals(participant.getUser(), User.COMPUTER);
        assertEquals(participant.getName(), "Jone");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }

    @Test
    public void createParticipant7() {
        Participant participant = Participant.builder().name("Jone").color(Color.GREEN).user(User.HUMAN).build();
        assertNotNull(participant);
        assertEquals(participant.getColor(), Color.GREEN);
        assertEquals(participant.getUser(), User.HUMAN);
        assertEquals(participant.getName(), "Jone");
        assertFalse(participant.getPlayerSet().isEmpty());
        assertEquals(participant.getPlayerSet().size(), 4);
    }


}