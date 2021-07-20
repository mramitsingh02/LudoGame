package com.ludo.rule;

import java.util.function.Predicate;

public class Condition<T> {

    private Predicate<T> test;

    public boolean test(T currentNumber) {
        return test.test(currentNumber);
    }

    public Condition(Predicate test) {
        this.test = test;
    }
}
