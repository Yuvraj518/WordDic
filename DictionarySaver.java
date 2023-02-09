package com.example.worddic;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    private  HashMap<String,String> Dlist;
    DictionarySaver(){
        Dlist=new HashMap<>();
    }
    HashMap<String,String> getDlist(){
        return Dlist;
    }
    void serializeHashMap() {
        try{
            FileOutputStream fos=new FileOutputStream("dictionaryData");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject("Dlist");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void deserilizeHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("dictionaryData");
        ObjectInputStream ois=new ObjectInputStream(fis);

        Dlist=(HashMap<String, String>) ois.readObject();

    }
}
