package com.ludo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RetryDiceRuleImpl implements Rule {

    private boolean isMax6DigitThreshold;
    private List<Integer> numbers = new ArrayList<>();
    private List<Condition> conditions;
    private static final int MAX_VALUE_FOR_USER = 18;
    private static final int MAX_DICE_NUMBER = 6;
    private int currentNumber;


    @Override
    public String getRuleDescription() {
        return "This Rule is applicable for 6 get many time or bit other player";
    }

    @Override
    public void setValue(int number) {
        currentNumber = number;
        numbers.add(currentNumber);
    }


    @Override
    public boolean isAllowed() {

        if (conditions.get(0).test(currentNumber) && conditions.get(1).test(numbers.stream().mapToInt(Integer::intValue).sum()))
        {
            return true;
        }
        return false;

    }

    @Override
    public void setCondition(Predicate<?>... rulePredicate) {
        this.conditions = Arrays.stream(rulePredicate).map(Condition::new).collect(Collectors.toList());
    }


}