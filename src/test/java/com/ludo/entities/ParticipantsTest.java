package com.ludo.entities;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ParticipantsTest {
    @Test
    public void createParticipants() {

        Participants participants = new Participants(4);
        participants.add(Participant.builder().name("Jone").color(Color.GREEN).user(UserType.HUMAN).build());
        assertNotNull(participants);
        assertFalse(participants.isEmpty());
        assertEquals(participants.size(), 1);
        assertTrue(participants.nextParticipant().isPresent());
        assertEquals(participants.nextParticipant().get().getName(), "Jone");
        assertEquals(participants.nextParticipant().get().getUserType(), UserType.HUMAN);
        assertEquals(participants.nextParticipant().get().getColor(), Color.GREEN);
        assertEquals(participants.nextParticipant().get().getPlayerSet().size(), 4);

    }
}
