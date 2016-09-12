package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public class Cat extends Animal {
    public Cat(String name, String color) {
        super(4, name, color, "Cat", Math.random() * 25);
    }

    public void grow () {
        setWeight(getWeight() * 3);
    }
}
