package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class LoadSave {



    public LoadSave(){
    }

    public static GrammarCollection loadGrammar(String filename) throws IOException,ClassNotFoundException{

            GrammarCollection grammars=null;
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("Creating new file.");
                file.createNewFile();
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            grammars = (GrammarCollection) ois.readObject();
            ois.close();
            return grammars;

    }


}
