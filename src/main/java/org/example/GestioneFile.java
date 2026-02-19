package org.example;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GestioneFile {

    public static void leggiConBufferedReader(String nomeFile){
        try (BufferedReader br= new BufferedReader(new FileReader(nomeFile))){
            String riga;
            while ((riga = br.readLine())!=null){
                System.out.println(riga);
            }
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file");
        }
    }

    public static List<Brano> leggiConGson(String nomeFile){
        try (BufferedReader br= new BufferedReader(new FileReader(nomeFile))) {
            Gson gson= new Gson();
            Type tipo = new TypeToken<List<Brano>>(){}.getType();
            List<Brano> brani = gson.fromJson(br, tipo);
            return brani;
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file");
            return null;
        }
    }

    public static void scriviConGson(String nomeFile, List<Brano> brani){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json= gson.toJson(brani);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura");
        }
    }
}
