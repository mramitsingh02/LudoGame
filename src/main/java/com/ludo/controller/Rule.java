package com.ludo.controller;

import java.util.function.Predicate;

public interface Rule {
    boolean isAllowed();
    String getRuleDescription();
    void setCondition(Predicate<?> ...rulePredicate);
    void setValue(int number);
}
