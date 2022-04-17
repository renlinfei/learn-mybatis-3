package com.chrisren.learnmybatis3.others;

public class Dog implements IAnimal {

    @Override
    public void info() {
        System.out.println("I am a dog");
    }

    @Override
    public void eat() {
        System.out.println("I am eating");
    }
}
