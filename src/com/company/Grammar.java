package com.company;

import java.util.ArrayList;
import java.util.List;

public class Grammar {
    private int id;
    private char[] terminal;
    private char[] non_terminal;
    private List<CreateRules> rules= new ArrayList<>();
    private char first;

    public Grammar(int id, String terminal, String non_terminal, char first){
        this.id=id;
        this.terminal=terminal.toCharArray();
        this.non_terminal=non_terminal.toCharArray();
        this.first=first;
    }

    public void addRule(CreateRules rule){
        rules.add(rule);
        System.out.println("Rule added.");
    }




}
