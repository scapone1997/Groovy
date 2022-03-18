package com.mypackage.oop

@groovy.transform.ToString
class Mammifero extends Animale{
    def grandezza

    @Override
    void verso(String s) {
        super.verso(s)
        print " ovveride\n"
    }
}
