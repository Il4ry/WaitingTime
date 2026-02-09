package org.example;

public class Brano {
    public int id;
    public String titolo;
    public String album;
    public String artista;
    public int durata;
    public int like;

    public Brano(int id, String titolo, String album, String artista, int durata, int like){
        this.id=id;
        this.titolo=titolo;
        this.album=album;
        this.artista= artista;
        this.durata= durata;
        this.like=like;
    }
}
