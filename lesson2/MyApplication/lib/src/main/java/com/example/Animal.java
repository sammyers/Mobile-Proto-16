package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public abstract class Animal implements Comparable<Animal> {

    private int legs;
    private String name;
    private String color;
    private String species;
    private double weight;

    public Animal(int legs, String name, String color, String species, double weight) {
        this.legs = legs;
        this.name = name;
        this.color = color;
        this.species = species;
        this.weight = weight;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal animal) {
        if (this.weight < animal.getWeight()) {
            return -1;
        } else if (this.weight == animal.getWeight()) {
            return 0;
        } else {
            return 1;
        }
    }

    abstract void grow();
}
