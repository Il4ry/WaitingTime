package org.example;

public class Utente {
    private String nome;
    private String password;

    public Utente(String nome, String password){
        this.nome= nome;
        this.password= password;
    }

    public void verifica(String nomeUtente, String pass){
        if (nomeUtente.equals(nome)){
            if (pass.equals(password)){
                System.out.println("Accesso completato");
            }else{
                System.out.println("Credenziali sbagliate");
            }
        }else {
            System.out.println("Credenzali sbagliate");
        }
    }
    public String getName(){
        return nome;
    }
    public String getPassword(){
        return password;
    }
}
