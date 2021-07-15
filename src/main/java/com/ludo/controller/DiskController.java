package com.ludo.controller;

import com.ludo.entities.Dice;

public class DiskController {
    public static void main(String[] args) {
        Dice dice = new Dice();
        for (int i = 0; i < 400; i++) {
            System.out.printf("Next Number %s \n", dice.roll());
        }
    }
}
