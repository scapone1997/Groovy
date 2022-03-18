package com.mypackage.intro
//Uso di assert
/*
def x = [1, 2]
x << 6
assert x == [1, 2, 7]
 */

//Modi per iterare una lista
/*

def list = [1,2,3,4]

for(num in list){
    print num
}

//Oppure

list.each { println it}
 */


/***************************** Testiamo classe Developer +********************************/

Developer dev = new Developer(first: "simone", last: "capone");
println "stampo dev con toStrin(): " + dev

dev.first = "Dan"
dev.setLast("Vega")

dev.languages << "Groovy"
dev.languages << "Java"

dev.work()

println "-------------------------------------"

/***************************** Testiamo classe Person +********************************/
def p1 = new Person(first:"Simone", last:"Capone")
def p2 = new Person(first:"Andrea", last:"Lugli")

def people = [p1, p2]
println people

def sortedPeople = people.sort(false)
println sortedPeople

println "-------------------------------------"

/***************************** Dati astratti in Groovy +********************************/
/**
 * Ogni variabile in Groovy è un oggetto. Ad esempio in x = 30 non implica che x sia una
 * variabile primitva come in Java. Ma bensì x è istanza della classe wrapper Integer.
 */
int x = 30
println x.getClass().getName()

float y = 3.25
println y.class

println 475.class

/**
Nel momento in cui usiamo il costrutto "def" stiamo dicendo a Groovy che non ci importa
quale tipo questa variabile ospita. Usando questo costrutto possiamo cambiare il tipo che la variabile
ospita nel tempo. Questo non è possibile farlo se avessimo usato int x = 4
 */

def var = 4
println "la classe di var è: " + var.class
var = new Developer()
println "la classe di var è: " + var.class

println "-------------------------------------"

/***************************** Overloading di operatori +********************************/
/**
Sappiamo che in Groovy ogni variabile ospita un oggetto. Nel momento in cui chiamiamo gli operartori
+,-,* stiamo in realtà chiamando dei metodi. Ad esempio l'istruzione:
    int x = 3
    int y = 4
    x + y
è equivalente ad:
    x.plus(y)
Di conseguenza possiamo fare un overloading degli operatori nelle nostre classi. Vedi esempio Account
 */
Account acc1 = new Account(balance: 45)
Account acc2 = new Account(balance: 1584)
println "Stampo oggetto acc1+acc2: " + (acc1 + acc2)

println "-------------------------------------"

/***************************** Utilizzare le Liste e Dizionari +********************************/
def list = [2,4,7, 3, 3]

//Creiamo una lista
list << [7, 8, 3, 10]
println list

list = list.flatten()
println list

//Creiamo un set partendo da una lista
def set = list as Set
println set

//Creiamo un dizionario
def map = [:]
def person = [first: "dan", last: "ciao", email: "ciao@gmail.it"]
println person.getClass().getName()

println "-------------------------------------"

