package com.company;

import java.io.Serializable;

public class CreateRules implements Serializable {

    private char variable;
    private String rule;

    public CreateRules(char start, String rule){
        this.variable =start;
        this.rule=rule;
    }


    public char getVariable() {
        return variable;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        if(rule.isEmpty()) return "empty";
        else return "{" + variable +
                "->" + rule + " }";
    }
}
