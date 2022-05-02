package com.company;

public class CreateRules {

    private char name;
    private char start;
    private char[] rule;

    public CreateRules(char start, String rule){
        this.start=start;
        this.rule=rule.toCharArray();
    }
}
