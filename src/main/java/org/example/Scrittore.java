package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class Scrittore implements Runnable {
    String nomeFile;

    public Scrittore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void scrivi() {
        BufferedWriter bw=null;
        try {
            bw = new BufferedWriter(new FileWriter(nomeFile));
            bw.write("File in output");
            bw.write("\n\r");
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura");
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Errore durante la scrittura");
                }
            }
        }


    }

    @Override
    public void run() {
        scrivi();
    }

}
