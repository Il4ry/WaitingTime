package org.example;

public class Main {
    public static void main(String[] args) {
        Thread lettore = new Thread(new Lettore("brani.json"));
        lettore.start();
    }
}