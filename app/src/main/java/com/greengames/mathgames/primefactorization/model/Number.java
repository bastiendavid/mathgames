package com.greengames.mathgames.primefactorization.model;

import java.util.Random;

import lombok.Value;

/**
 * Number to be factorized into prime numbers.
 */
@Value
public class Number {

    private int number;
    private static final Random random = new Random();

    public Number(int lowerThan) {
        this.number = random.nextInt(lowerThan);
    }

    protected static final boolean isPrime(int number) {
        if (number == 1) {
            return true;
        }
        for (int n = 2; n < number; ++n) {
            if (number % n == 0) {
                return false;
            }
        }
        return true;
    }
}
