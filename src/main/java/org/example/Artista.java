package org.example;

import java.util.ArrayList;

public class Artista {
    private String name;

    public Artista(String name){
        this.name= name;
    }
    ArrayList<Brano> brani = new ArrayList<>();

    public void caricaBrano(Brano b){
        brani.add(b);
    }
}
