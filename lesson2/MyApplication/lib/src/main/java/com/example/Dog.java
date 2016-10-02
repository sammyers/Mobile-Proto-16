package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public class Dog extends Animal {
    public Dog(String name, String color) {
        super(4, name, color, "Dog", Math.random() * 25);
    }

    public void grow () {
        setWeight(getWeight() * 1.5);
    }
}
