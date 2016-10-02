package com.example;

/**
 * Created by smyers on 9/12/2016.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public Fraction add(Fraction otherFraction) {
        int newNumerator1 = numerator * otherFraction.denominator;
        int newNumerator2 = otherFraction.numerator * denominator;
        int newDenominator = denominator * otherFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator1 + newNumerator2, newDenominator);
        newFraction.simplify();
        return newFraction;
    }

    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
}
