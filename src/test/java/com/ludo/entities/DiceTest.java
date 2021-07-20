package com.ludo.entities;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class DiceTest {
    Dice dice = new Dice();

    @Test
    public void testRoll() {
        int result = dice.roll();
        assertDiceRoll(result);
        Assert.assertEquals(dice.toString(), String.valueOf(result));
    }

    private void assertDiceRoll(int result) {
        Assert.assertTrue(result > 0);
        Assert.assertTrue(result < 7);
        Assert.assertFalse(result < 0);
        Assert.assertFalse(result > 6);

    }

    @Test
    public void testManyTime() {
        IntStream.iterate(1, x -> x + 1).limit(90000000).forEach((x) -> {
            testRoll();
        });
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme