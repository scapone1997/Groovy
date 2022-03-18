package com.mypackage.closure

import com.mypackage.closure.ScopeDemo

/***************************** Closure +********************************/

//Una closure viene scritta con le parentesi graffe. Nel momento in cui abbiamo scritto
//il codice sotto abbiamo creato una istanza della classe Closure. Una closure è dunque
//un oggetto istanza della classe Closure.
def cl = {}
println cl.class


//Sembra simile ad un metodo ma in realtà è diverso. Una metodo non può essere passato
//come argomento mentre una Closure, essendo un oggetto, si.
//Una closure è un blocco di codice che si comporta come una funzione anonima.
def sayHello = {
    name, cognome -> println "Ciao, $name $cognome"
}

sayHello("simone", "capone")

//Creiamo una lista. Questo modo di iterare la lista è un utilizzo delle Closure.
//Il metodo each prende una Closure come argomento.
def list = [1, 3, 7, 9]
list.each {it -> print it}
println "\n------------------------------------------------"

//Vediamo un utilizzo molto utile delle Closure. Scriviamo il  metodo timesTen.
//Questo metodo prende in input una variabile ed un oggetto di tipo closure. Quello
//che fa è chiamare la closure passandogli come argomento un numero. A seconda della closure che
//gli passo avrò un effetto diverso.
def timesTen(num, closure){
    closure(num * 10)
}

timesTen(4, {it -> println(it)})
def y = timesTen(4, {return it-4})
def obj = timesTen(4, {return (String)it})
println y
println "obj" + obj.class

//Una cosa importante è che quando un metodo prende in input vari argomenti e l'ultimo
//di questo argomenti è una closure possiamo usare la sinstassi sotto. Questa sintassi ci fa capire
//che il metodo timesTen prende in input un numero ed un oggetto istanza della classe Closure.
def obj2 = timesTen(4){
    return it-4
}

println obj2

println "------------------------------------------------"

//Una closure può prevedere più parametri. Questi parametri possono avere dei valori di default
//utili per quando chiamiamo la closure con meno argomenti di quelli ufficiali come nel seguente
//esempio.
def greet = {
    String name, String greeting = "Hey" ->
        println "$greeting, $name"
}

greet("Simone", "Buongiorno")
greet("Simone")

println "------------------------------------------------"

//Altri utilizzi molto utili delle Closure quando si hanno a che fare con le Collections.
List days = ["lunedi", "venerdi", "domenica"]
List weekend = days.findAll {it.startsWith("v")}

println days
println weekend
println ""

List nums = [1,2,3,4,5,6]
List numsTimesTen = []
nums.each {it->numsTimesTen << it*10}

println nums
println numsTimesTen

println "------------------------------------------------"

/*
    Trattazione dei costrutti this, owner e delegate
 */

def demo = new ScopeDemo()
demo.outerClosure()

println "------------------------------------------------"

/*
    Scriviamo ora la seguente closure e chiamiamola in questo script.
 */
def writer = {
    append 'Dan'
    append 'viva a Londra'
}

//writer() ---> solleva eccezione!
println writer.delegate.class.name

/*
 *  Quando viene chiamata append la closure cerca fuori se stessa il metodo append, nello specifico cerca
 *  nella enclosing class, che in questo caso è la classe che noi non vediamo ma che viene autmaticamente creata
 *  per lo script closure.groovy.
 *  Dato che non trova nessun metodo append, controlla chi è il delegato. In questo caso il delegato è per default
 *  la classe dello script e dunque l'esecuzione si ferma sollevando eccezione.
 */

/*  Se invece facciamo così: */
StringBuffer sb = new StringBuffer()
writer.delegate = sb
//writer.resolveStrategy = Closure.DELEGATE_FIRST;
println "Resolve strategy: " + writer.resolveStrategy
writer()
println writer.delegate.class.name

/*
 *  Adesso funziona perchè abbiamo cambiato il delegato. Abbiamo messo come delegato
 *	un oggetto di StringBuffer che possiede il metodo append. Abbiamo delegato
 *  la responsabilità della writer closure al nostro StreamBuffer.

 *  Che succede se dentro questo script inserisco un metodo append personale?
    Vediamo..
 */

def append(String s){
     println "append() chiamato con argomento $s"
 }

/*
 * Osserviamo che viene chiamato il metodo append definito da noi. Perchè?
 * Perchè nel risolvere questa chiamata Groovy segue un path prestabilito. Il path di default
 * è quello del "owner first". Ovvero: il metodo presente nella classe dove la closure è scritta ha la precedenza.
 * Se non lo trova qua, cerca altrove.

 * Ma allora dobbiamo cambiare strategia per il risolvimento della chiamata.
 * Togliamo il commento dalla linea 117 e abbiamo cambiato strategia.
 *
 * Cambiare il delegato ci fa capire che le Closure che Groovy offre non sono uguali
 * alle lambda-espressioni.
 */
