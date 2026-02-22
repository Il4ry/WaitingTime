package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //istanza contatore
        Thread contatore = new Thread(() -> {
            try {
                for (int i = 3; i > 0; i--) {
                    System.out.println("Inizio tra " + i + "...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.err.println("Contatore interrotto: " + e.getMessage());
            }
        });
        contatore.start();

        try {
            contatore.join();
        } catch (InterruptedException e) {
            System.err.println("Errore join contatore: " + e.getMessage());
        }

        //lettura con gson
        System.out.println("Lettura con Gson");
        List<Brano> brani= GestioneFile.leggiConGson("brani.json");
        if (brani != null) {
            for (Brano b : brani) {
                System.out.println(b);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Aggiungi nuovo brano");
        System.out.print("Inserisci titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci album: ");
        String album = scanner.nextLine();
        System.out.print("Inserisci artista: ");
        String artista = scanner.nextLine();
        System.out.print("Inserisci durata: ");
        int durata = scanner.nextInt();
        brani.add(new Brano(titolo, album, artista, durata));

        Thread scrittore = new Thread(new Scrittore("brani.json"));
        scrittore.start();

        GestioneFile.scriviConGson("brani.json", brani);
        System.out.println("File salvato");

        scanner.close();


        Thread lettore = new Thread(new Lettore("brani.json"));
        lettore.start();
    }
}