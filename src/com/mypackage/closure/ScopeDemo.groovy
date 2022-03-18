package com.mypackage.closure

/*
    All'interno dell'oggetto closure con this ci riferiamo all'enclosing class dove
    la closure è definita. Nel caso parliamo di uno scropt avviene lo stesso. Infatti
    quando creiamo uno script viene creata una classe per lo script anche se non la specifichiamo.

    Con owner ci riferiamo all'enclosing object dove la closure è definita, che può essere una classe o
    un oggetto.

    Con delegate ci riferiamo ad un oggetto di terze parti dove le chiamate ai metodi
    o le proprietà sono risolte ogni qualvolta il ricevente del messaggio non è definito.

 */
class ScopeDemo {
    def outerClosure = {
        println this.class.name
        println owner.class.name
        println delegate.class.name

        def nestedClosure = {
            println this.class.name
            println owner.class.name
            println delegate.class.name
        }
        nestedClosure()
    }
}
