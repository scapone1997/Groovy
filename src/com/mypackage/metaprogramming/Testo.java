package com.mypackage.metaprogramming;

public class Testo {
}


/**
 * Nel momento in cui chiamiamo un metodo, la chiamata passa da un livello intermedio chiamato MOP.
 * MOP sta per Meta Object Protocol. In questo livello si decide a quale metodo legare quella determinata
 * chiamata. In Java, se ho il metodo method() della classe Class sappiamo che la chiamata viene legata
 * a quel metoodo. Qua invece si passa per questo strato intermedio a cui chiediamo come risolvere
 * la chiamata al metodo.
 *
 * Nel momento in cui abbiamo a che fare con le chiamate dei metodi in Groovy possiamo avere a che fare con
 * tre tipi di oggetti:
 *  - POJO: un normale oggetto Java che può essere scritto in Java o in qualsiasi altro linguaggio
 *          per la JVM.
 *  - POGO: un oggetto Groovy la cui classe è scritta in Groovy. Deve estendere la classe java.lang.Object ed
 *          implementare l'interfaccia groovy.lang.GroovyObject per default.
 *  - Groovy Interceptor: un oggetto Groovy che implementa l'interfaccia groovy.lang.GroovyInterceptable e che abbia
 *                        la capacità di di intercettare i metodi.
 */