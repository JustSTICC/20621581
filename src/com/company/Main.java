package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Grammar g1=new Grammar(1,"A","abc",'S');

        Scanner input= new Scanner(System.in);

        char s= input.next().charAt(0);
        input.skip("->");
        String rule= input.nextLine();
        System.out.println(s+"->"+rule);

        CreateRules newRule= new CreateRules(s,rule);
        g1.addRule(newRule);



    }
}
