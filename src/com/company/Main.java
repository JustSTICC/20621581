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

            System.out.println("Write command '>help' to see available commands.");

            boolean exit = false;
            while (!exit) {


                System.out.print(">");
                Scanner input = new Scanner(System.in);
                String[] commands = input.nextLine().split(" ");
                String command = commands[0];
                switch (command) {
                    case "chomsky":{
                        if(commands.length!=2){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        int id = Integer.parseInt(commands[1]);
                        grammarCollection.chomskiCheckById(id);
                        break;
                    }
                    case "chomskify":{
                        if(commands.length!=2){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        int id = Integer.parseInt(commands[1]);
                        break;

                    }
                    case "union":{
                        if(commands.length!=3){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        int id1 = Integer.parseInt(commands[1]);
                        int id2 = Integer.parseInt(commands[2]);
                        grammarCollection.union(id1,id2);
                        int size = grammarCollection.getGrammars().size();
                        grammarCollection.printById(size);
                        break;
                    }
                    case "list":{
                        if(commands.length!=1){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        grammarCollection.list();
                        break;
                    }
                    case "print":{
                        if(commands.length!=2){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        int id = Integer.parseInt(commands[1]);
                        grammarCollection.printById(id);
                        break;


                    }

                    case "addRule": {

                        if(commands.length!=3){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }

                        int id = Integer.parseInt(commands[1]);
                        String ruleEx= commands[2];
                        char s = ruleEx.charAt(0);
                        String rule = ruleEx.substring(3);
                        System.out.println(rule);

                        CreateRules newRule = new CreateRules(s, rule);
                        grammarCollection.addRuleById(id,newRule);
                        break;


                    }
                    case "removeRule":{
                        if(commands.length!=3){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        int id = Integer.parseInt(commands[1]);
                        int number = Integer.parseInt(commands[1]);
                        grammarCollection.removeRuleById(id,number);
                        break;

                    }
                    case "save": {
                        if(commands.length!=1){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }

                        if(filename==null) {
                            System.out.println("No file opened!");
                            continue;
                        }
                        else {

                            Save.saveGrammar(grammarCollection,filename);
                            break;

                        }
                    }
                    case "saveAs": {
                            if(commands.length!=2){
                                System.out.println("Invalid number of arguments!");
                                continue;
                            }

                            filename = commands[1];
                            Save.saveGrammar(grammarCollection,filename);
                            break;

                    }
                    case "open":{
                        if(commands.length!=2){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }

                        filename = commands[1];
                        grammarCollection=LoadSave.loadGrammar(filename);
                        System.out.println("File opened.");
                        break;

                    }
                    case "close":{
                        if(commands.length!=1){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        grammarCollection=LoadSave.loadGrammar(filename);
                        filename=null;
                        System.out.println("File closed without saving.");
                        break;
                    }
                    case "exit":
                        if(commands.length!=1){
                            System.out.println("Invalid number of arguments!");
                            continue;
                        }
                        exit = true;
                        break;
                    case "help":{
                        System.out.println("Included commands:");
                        System.out.println("list - list of all grammars with their corresponding id.");
                        System.out.println("print <id> - outputs a specific grammar with the corresponding id.");
                        System.out.println("save - save changes to all grammars in the last opened file.");
                        System.out.println("saveAs <filepath> - save changes to all grammar in a file chosen by the user.");
                        System.out.println("open <filepath> - load grammar from a file chosen by the user.");
                        System.out.println("close - closes the file without saving any changes.");
                        System.out.println("addRule <id> <rule> - adds new rule in a grammar with their corresponding id.(rule format: 'start letter'->'rule' )");
                        System.out.println("removeRule <id> <n> - remove rule by its number in a grammar with their corresponding id.");
                        System.out.println("union <id1> <id2> - unites two grammars and outputs the new grammar with its corresponding id.");
                        System.out.println("concat <id1> <id2> - out of order");
                        System.out.println("chomsky <id> - checks if the grammar with the corresponding id is in Chomsky's normal form.");
                        System.out.println("cyk <id> - out of order.");
                        System.out.println("iter <id> - out of order.");
                        System.out.println("empty <id> - out of order.");
                        System.out.println("chomskify <id>- out of order.");
                        System.out.println("exit - exit the program.");


                    }
                }
            }

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
