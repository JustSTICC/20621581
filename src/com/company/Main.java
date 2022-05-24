package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {
        try {
            String filename=null;

            Grammar g1 = new Grammar("A", "abv", 'S');
            Grammar g2 = new Grammar("B", "acb", 'K');



            List<Grammar> grammarList = new ArrayList<>();


            grammarList.add(g1);
            grammarList.add(g2);

            GrammarCollection grammarCollection= new GrammarCollection(grammarList);

            Scanner input = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {


                System.out.println("Enter command: ");
                String comment = input.nextLine();
                switch (comment) {
                    case "chomsky":{
                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(input.nextLine());
                        grammarCollection.chomskiCheckById(id);
                        break;
                    }
                    case "chomskify":{
                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(input.nextLine());
                        break;

                    }
                    case "union":{
                        System.out.println("Enter id1: ");
                        int id1 = Integer.parseInt(input.nextLine());
                        System.out.println("Enter id2: ");
                        int id2 = Integer.parseInt(input.nextLine());
                        grammarCollection.union(id1,id2);
                        int size = grammarCollection.getGrammars().size();
                        grammarCollection.printById(size);
                        break;
                    }
                    case "list":{
                        grammarCollection.list();
                        break;
                    }
                    case "print":{
                        //grammarCollection.toString();
                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(input.nextLine());
                        grammarCollection.printById(id);
                        break;


                    }

                    case "addRule": {

                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(input.nextLine());
                        System.out.println("Enter rule: ");

                        char s = input.next().charAt(0);
                        input.nextLine();
                        System.out.println("->");
                        String rule = input.nextLine();
                        System.out.println(rule);

                        CreateRules newRule = new CreateRules(s, rule);
                        grammarCollection.addRuleById(id,newRule);
                        break;


                    }
                    case "removeRule":{
                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(input.nextLine());
                        System.out.println("Rule number: ");
                        int number = Integer.parseInt(input.nextLine());
                        grammarCollection.removeRuleById(id,number);
                        break;

                    }
                    case "save": {

                        if(filename==null) {
                            System.out.println("No file opened!");
                            continue;
                        }
                        else {

                            System.out.println("Enter id:");
                            int id = Integer.parseInt(input.nextLine());
                            Save.saveGrammar(grammarCollection,filename);
                            break;

                        }
                    }
                    case "saveAs": {

                            System.out.println("Enter file location: ");
                            filename = input.nextLine();
                            Save.saveGrammar(grammarCollection,filename);
                            break;

                    }
                    case "open":{

                        System.out.println("Enter file location: ");
                        filename = input.nextLine();
                        grammarCollection=LoadSave.loadGrammar(filename);
                        System.out.println("File opened.");
                        break;

                    }
                    case "close":{
                        grammarCollection=LoadSave.loadGrammar(filename);
                        filename=null;
                        System.out.println("File closed.");
                    }
                    case "exit":
                        exit = true;
                        break;
                }
            }
            input.close();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
