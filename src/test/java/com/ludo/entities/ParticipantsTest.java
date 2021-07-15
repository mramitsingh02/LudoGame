package com.ludo.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParticipantsTest {
    @Test
    public void createParticipants() {

        Participants participants = new Participants(4);
        participants.add(Participant.builder().name("Jone").color(Color.GREEN).user(User.HUMAN).build());
        assertNotNull(participants);
        assertFalse(participants.isEmpty());
        assertEquals(participants.size(), 1);
        assertTrue(participants.nextParticipant().isPresent());
        assertEquals(participants.nextParticipant().get().getName(), "Jone");
        assertEquals(participants.nextParticipant().get().getUser(), User.HUMAN);
        assertEquals(participants.nextParticipant().get().getColor(), Color.GREEN);
        assertEquals(participants.nextParticipant().get().getPlayerSet().size(), 4);

    }
}
