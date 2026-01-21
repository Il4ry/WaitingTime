package org.example;

import java.io.FileReader;
import java.io.IOException;

public class Lettore implements Runnable {
    String nomeFile;

    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }

    public void leggi(){
        int i=0;
        try (FileReader fr = new FileReader(nomeFile)) {
            while(i != -1){
                i= fr.read();
                System.out.print((char) i);
            }
            fr.close();
        } catch (IOException e) {
            System.err.println("Errore lettura file: ");
        }
    }

    public void run(){
        leggi();
    }
}
