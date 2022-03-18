package com.mypackage.oop

/**
 * I traits sono componenti riutilizzabili che rappresentano un insieme di metodi o comportamenti
 * che possiamo usare per estendere la funzionalità di più classi. Per questo motivo, sono considerati
 * come interfacce, portando sia le implementazioni predefinite che lo stato.
 *
 * Dunque sono come interfacce ma con la possibilità di avere uno stato.
 */
trait FlyingAbility {

    def attributo

    String fly(){
        "I'm flying!"
    }

    abstract String speak()
}