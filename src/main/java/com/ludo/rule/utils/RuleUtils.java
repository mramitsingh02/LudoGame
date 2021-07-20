package com.ludo.rule.utils;

import java.util.function.Predicate;

public class RuleUtils {

    private static final int MAX_VALUE_FOR_USER = 18;
    private static final int MAX_DICE_NUMBER = 6;
    public static Predicate<Integer> is6Number = (number) -> number == MAX_DICE_NUMBER ;
    public static Predicate<Integer> diceMaxThresholdRich = (sum) -> sum <= MAX_VALUE_FOR_USER;




}
