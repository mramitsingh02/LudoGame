package com.ludo.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public static final int MAX = 6;
    private int currentNumber;

    public int roll() {
        currentNumber = ThreadLocalRandom.current().nextInt(1, 7);
        return currentNumber;
    }

    private boolean isMaxNumberOfDice() {
        return currentNumber == MAX;
    }

    public int allTime6() {
        return MAX;
    }

    @Override
    public String toString() {
        return String.valueOf(currentNumber);
    }
}
