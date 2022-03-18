package com.mypackage.beans;

import java.io.Serializable;

/**
 * Nel mondo Java, un Bean è una classe che segue determinati standard. In particolare, un bean deve:
 *   - avere tutti gli attributi privati (per accedere alle proprietà usiamo getter/setter)
 *   - un costruttore publico a 0 argomenti
 *   - implementare l'interfaccia Serializable
 *
 *   La classe sotto è un Bean. Tuttavia il problema è che per 3 attributi abbiamo già creato
 *   diverse linee di codic solo per poter accedere e modificare i dati. Immaginiamo
 *   quando un oggetto ha tantissimi attributi quanto diventa complesso gestire tutto questo codice.
 *   Se voglio modificare l'attributo nome chiamandolo "nomeDip" devo modificare tutti i metodi ad esso
 *   collegati.
 *
 *   Vediamo come creare lo stesso Bean in Groovy.
 */
public class DipendenteBean implements Serializable {
    private String nome;
    private String cognome;

    public DipendenteBean(){

    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "DipendenteBean{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
