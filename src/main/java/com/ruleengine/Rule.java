package com.ruleengine;

public class Rule {
    private String name;
    private String condition;
    private String action;

    public Rule(String name, String condition, String action) {
        this.name = name;
        this.condition = condition;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }
}
