package com.ludo.controller;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    private List<Rule> ruleList = new ArrayList<>();

    public void add(Rule rule) {
        ruleList.add(rule);
    }

    public void setNumber(int number) {
        ruleList.forEach(x -> x.setValue(number));
    }

    public boolean isAllowed() {

        for (Rule rule : ruleList) {
            if (rule.isAllowed()) {
                return true;
            }
        }
        return false;

    }


    public void registerRule(Rule rule) {
        add(rule);
    }
}
