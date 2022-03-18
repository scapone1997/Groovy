package com.mypackage.oop

/**
 * Come sappiamo, in Groovy ogni qualvolta creiam ouna classe viene prodotta un equivalente classe Java.
 * Sulle classi che creiamo in Groovy valgono tutte le cose che conosciamo sulla OOP.
 * Vedere cosa produce IntelliJ nella cartella out per capire come viene tradotta.
 * Quando non specifichiamo la visibilità dei metodi vengono messi per default come pubblici.
 * Quando non specifichiamo la visibilità degli attributi vengono messi per default come privati.
 * Nel momento in cui scriviamo noi la visibilità in groovy, sarà utilizzata quella.
 */
@groovy.transform.ToString
class Animale {
    def nome
    def razza

    void verso(String s){
        print s
    }
}
