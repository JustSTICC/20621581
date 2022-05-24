package com.company;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.List;

abstract class Save {

    public Save(){
    }

    public static void saveGrammar(GrammarCollection grammarCollection,String  filename) throws IOException {

        File file= new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        if(!file.exists()) file.createNewFile();

        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(grammarCollection);
        System.out.println("File successfully saved!");
        oos.close();
    }



}
