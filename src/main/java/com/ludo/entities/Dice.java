package com.ludo.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int currentNumber;

    public int roll() {
        currentNumber = ThreadLocalRandom.current().nextInt(1, 7);
        return currentNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(currentNumber);
    }
}
