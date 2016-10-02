package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public class Cow extends Animal{
    public Cow(String name, String color) {
        super(4, name, color, "Cow", Math.random() * 100 + 100);
    }

    public void grow () {
        setWeight(getWeight() * 5);
    }
}
