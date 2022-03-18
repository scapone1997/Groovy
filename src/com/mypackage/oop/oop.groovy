package com.mypackage.oop

import com.mypackage.oop.Animale

//Creiamo un istanza di animale
Animale animale = new Animale(nome: "Gatto", razza: "Maine Coon")
println animale

Animale altro = new Mammifero(nome: "Cane", razza: "Doberman")
altro.verso("bau")
println altro

altro.setGrandezza(14.74)
println altro

println "--------------------------------------------"

Bird bird = new Bird(nome: "falco", razza: "pellegrino")
println bird.fly()
println bird.getAttributo()

bird.speak()
println bird.getAttributo()

