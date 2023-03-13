package com.liskovsubstitution;

public class Pigeon implements CantFly {

    @Override
    public void canEat() {
        System.out.println("Pigeon is eating");
    }

    @Override
    public void canBreath() {

    }

    @Override
    public void cantFly() {

    }

    public void pigeon() {}
}
