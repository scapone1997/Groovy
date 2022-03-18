package com.mypackage.intro

//importiamo le annotations
import groovy.transform.*;

//L'annotation toString() permette di definire automaticamente un metodo di stampa per Developer
@ToString()
class Developer {
    String first
    String last
    def languages = []

    void work(){
        println "$first $last is working..."
    }
}
