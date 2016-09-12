package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by smyers on 9/12/2016.
 */
public class Farm {
    private  ArrayList<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Animal getAnimal(int index) {
        return animals.get(index);
    }

    public ArrayList<Animal> getHeaviestAnimals() {
        ArrayList<Animal> newList = new ArrayList<Animal>(animals);
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(newList, comparator);
        return newList;
    }

    public void printCatNames() {
        for (int i=0; i < animals.size(); i++) {
            Animal thisAnimal = animals.get(i);
            if (thisAnimal.getSpecies() == "Cat") {
                System.out.println(thisAnimal.getName());
            }
        }
    }

    public double averageLegs() {
        int numAnimals = animals.size();
        int total = 0;
        for (int i=0; i < numAnimals; i++) {
            total += animals.get(i).getLegs();
        }

        return total / numAnimals;
    }
}
