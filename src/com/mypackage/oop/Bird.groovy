package com.mypackage.oop

class Bird extends Animale implements FlyingAbility{

    @Override
    String speak() {
        this.setAttributo("attributo")
        return "cip cip"
    }
}
