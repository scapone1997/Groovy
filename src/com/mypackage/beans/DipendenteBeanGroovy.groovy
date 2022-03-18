package com.mypackage.beans

/**
 * In Groovy l'equivalente di ciò che abbiamo scritto in DipendenteBean è ottenuto
 * con sole 4 righe di codice.
 */

@groovy.transform.ToString
class DipendenteBeanGroovy implements Serializable{
    String nome, cognome

    String getCognome(){
        "Lugli"
    }
}
