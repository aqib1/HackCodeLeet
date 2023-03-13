package com.liskovsubstitution;

public class Test {
    public static void main(String[] args) {
        Bird ebird = new Emu();
        ebird.canEat();
        Bird pbird = new Pigeon();
        pbird.canEat();
    }
}
