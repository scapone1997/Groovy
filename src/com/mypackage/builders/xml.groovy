package com.mypackage.builders

import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper

/**
 * I builder sono un modo conveniente e pratico per costruire un oggetto.
 * Vedremo come costruire builder per ottenere oggetti XML, HTML e JSON
 */
FileWriter writer = new FileWriter('xml/sports.xml')
MarkupBuilder markupBuilder = new MarkupBuilder(writer)

markupBuilder.omitEmptyAttributes = true
markupBuilder.omitNullAttributes = true

/**
 * Stiamo chiamando il metodo sports() sull'oggetto markupBuilder.
 * Notiamo che sports(..) è un metodo che possiede come argomento una Closure
 * e per quello che ci siamo detti nella sezione "closure" sappiamo che possiamo usare
 * la sintassi sotto.
 *
 * Tuttavia notiamo un altra cosa importante. Se vado a vedere la documentazione della classe
 * MarkupBuilder scopro che non esiste nessun metodo sports(). Ma allora cosa stiamo chiamando?
 * Perciò sappiamo che ci sarà qualche missingMethod implementato che catturerà la chiamata di
 * questo metodo. Nel nostro caso quello che farà la cattura della chiamata da parte del missingMethod
 * è creare un documento in formato xml.
 */
markupBuilder.sports{
    sport(id:1){
        name "Baseball"
    }
    sport(id:2){
        name "Basketball"
    }
    sport(id:3){
        name "Football"
    }
    sport(id:4){
        name "Hockey"
    }
    sport(id: null, foo:''){
        name ''
    }
}

/**
 * Se runno questo script otterò un documento in formato xml dentro la cartella xml.
 *
 * Supponiamo ora di avere già a disposizione il file che abbiamo creato. Vogliamo fare l'operazione inversa.
 * Nello specifico, da un file in formato xml vogliamo poterlo manipolare in modo da
 * risalire ai nomi dei vari sport.
 */
def sports = new XmlSlurper().parse('xml/sports.xml')

//Stampiamo tutti gli sport
println sports

//stampiamo solo quello che ci interessa
println sports.sport[2].name

