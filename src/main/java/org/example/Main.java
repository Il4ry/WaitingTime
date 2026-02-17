package org.example;

import java.net.SocketOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread lettore = new Thread(new Lettore("brani.json"));
        lettore.start();
        Utente u= new Utente("Ilaria", "ciao1234");

        Scanner s= new Scanner(System.in);
        System.out.println("Inserire nome utente: ");
        String nome=s.nextLine();
        System.out.println("Inserire password: ");
        String password=s.nextLine();
        u.verifica(nome,password);


    }
}