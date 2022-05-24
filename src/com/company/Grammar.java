package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grammar implements Serializable {



    private String terminal;
    private String non_terminal;
    private Set<CreateRules> rules= new HashSet<>();
    private char first;


    public Grammar( String terminal, String non_terminal, char first){

        this.terminal=terminal;
        this.non_terminal=non_terminal;
        this.first=first;
    }

    public boolean chomskiCheck(){
        boolean check=true;
        for(CreateRules r : this.rules){
            if(r.getRule().length()>2) {
                check=false;
                break;
            }
        }
        return check;
    }

    public void chomskify(){
        for(CreateRules r : this.rules){
            while(r.getRule().length()>2){
                char variable =r.getVariable();
                int a= 1 + (int)variable;
                char newVariable =  (char)a;
                String newWord = r.getRule().substring(0,r.getRule().length()-1);
                r.setRule(r.getRule().substring(0,1));
                CreateRules newRule = new CreateRules(newVariable,newWord);
                rules.add(newRule);
            }
        }


    }

       public boolean cyk(String word){return false;}
//
//    int n= word.length();
//    String[][] table = new String[n][n];
//    Set<CreateRules> newRules = new HashSet<>();
//    for( CreateRules rule : this.rules){
//        if(rule.getVariable()==this.first) newRules.add(rule);
//    }
//    if(newRules.isEmpty()) return true;
//    else{
//        for(char ch : word.toCharArray()){
//            if(this.rules.);
//        }
//    }
//    }

    public void addRule(CreateRules rule){
        boolean check=false;
        if(first==rule.getVariable()) check=true;
        else{
            for(int i=0;i<this.non_terminal.length();i++) {
                if (rule.getVariable() == non_terminal.charAt(i)) {
                    check = true;
                    break;
                }
        }
        }
        if(check==true){rules.add(rule);}
        else System.out.println("Non-terminal doesn't exist!");
    }
    public void removeRule(int id){
        this.rules.remove(id-1);
    }

    public void setRules(Set<CreateRules> rules) {
        this.rules = rules;
    }

    public char getFirst() {
        return first;
    }

    public String getNon_terminal() {
        return non_terminal;
    }

    public String getTerminal() {
        return terminal;
    }

    public Set<CreateRules> getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "G={ " +
                "{" + terminal  +
                "}, {" + non_terminal +
                "}, P" + rules.toString() +
                ", " + first +
                " }";
    }
}
