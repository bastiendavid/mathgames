package com.greengames.mathgames.primefactorization.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Number to be factorized into prime numbers.
 */
@Data
public class Number {

    private static final Random random = new Random();

    @Setter(AccessLevel.PROTECTED)
    private int number;
    private final List<Integer> factors = new ArrayList<>();

    public Number(int lowerThan) {
        this.number = random.nextInt(lowerThan);
        factorize();
    }

    protected void factorize() {
        factors.clear();
        // optimization if is prime
        if (isPrime(number)) {
            factors.add(number);
            return;
        }

        // find all factors
        int remainder = number;
        for (int i = 2; i <= remainder; ++i) {
            if (isPrime(i) && remainder % i == 0) {
                factors.add(i);
                remainder = remainder / i;
                // try again if can be divided by the same number multiple times
                --i;
            }
        }
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

    /**
     * Give all primesUnder under max. 1 is excluded.
     *
     * @param max
     */
    public static List<Integer> primesUnder(int max) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; ++i) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
