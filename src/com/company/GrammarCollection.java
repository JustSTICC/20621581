package com.company;

import java.io.Serializable;
import java.util.*;

public class GrammarCollection implements Serializable {
    private List<Grammar> grammars= new ArrayList<>();

    public GrammarCollection(List<Grammar> grammars) {
        this.grammars = grammars;
    }

    public GrammarCollection() {

    }

    public void addGrammar(Grammar grammar){
        this.grammars.add(grammar);
    }

    @Override
    public String toString() {
        return "com.company.GrammarCollection{" +
                "grammars=" + this.grammars.toString();
    }
    
    public void addRuleById(int id, CreateRules rule){
        if(this.grammars.size()>=id && id>0) {
            this.grammars.get(id - 1).addRule(rule);
            System.out.println("Successfully added " + rule.getVariable() + "->" + rule.getRule());
        }
        else System.out.println("Invalid id!");

    }
    public void removeRuleById(int id, int num){
        if(this.grammars.size()>=id && id>0) {
            this.grammars.get(id - 1).removeRule(num);
            System.out.println("Rule successfully removed ");
        }
        else System.out.println("Invalid id!");

    }
    public void chomskiCheckById(int id){
        if(this.grammars.get(id-1).getRules().isEmpty()) System.out.println("No rules found!");
        else if(this.grammars.get(id-1).chomskiCheck()) System.out.println("Does pass the Chomski check.");
        else System.out.println("Doesn't pass the Chomski check.");
    }
    public void chomskifyById(int id){
    if(this.grammars.get(id-1).getRules().isEmpty()) System.out.println("No rules found!");
        else if(this.grammars.get(id-1).chomskiCheck()){
            this.grammars.get(id-1).chomskify();
    }
        else System.out.println("Doesn't pass the Chomski check.");
    }
    
    public void printById(int id){
        if(this.grammars.size()>=id && id>0) {
            System.out.println(id + ". " + this.grammars.get(id - 1).toString());
        }
    }
    public void union(int id1, int id2){

        Set<Character> ch= new TreeSet<>();
        Grammar grammar1 = grammars.get(id1-1);
        Grammar grammar2 = grammars.get(id2-1);
        String terminal = grammar1.getTerminal()+grammar2.getTerminal();
        for( char c : terminal.toCharArray()){
            ch.add(c);
        }
        terminal=ch.toString();

        ch.clear();
        String nonterminal = grammar1.getNon_terminal()+grammar2.getNon_terminal();
        for( char c : nonterminal.toCharArray()){
            ch.add(c);
        }

        nonterminal=ch.toString();
        Grammar union = new Grammar(terminal,nonterminal,grammar1.getFirst());
        this.grammars.add(union);

        Set<CreateRules> newRules = new HashSet<>();
        newRules.addAll(grammar1.getRules());
        newRules.addAll(grammar2.getRules());

        this.grammars.get(this.grammars.size()-1).setRules(newRules);

    }

    public void concat(int id1, int id2){
        Set<Character> ch= new TreeSet<>();
        Grammar grammar1 = grammars.get(id1-1);
        Grammar grammar2 = grammars.get(id2-1);

        String nonterminal = grammar1.getNon_terminal()+grammar2.getNon_terminal();
        for( char c : nonterminal.toCharArray()){
            ch.add(c);
        }
        nonterminal=ch.toString();


    }


    public void list(){
        int i=1;
        for(Grammar grammar : this.grammars){
            System.out.println(i + ". " + grammar.toString() + "\n");
            i++;
        }
    }



    public List<Grammar> getGrammars() {
        return grammars;
    }

    public void setGrammars(List<Grammar> grammars) {
        this.grammars = grammars;
    }
}
