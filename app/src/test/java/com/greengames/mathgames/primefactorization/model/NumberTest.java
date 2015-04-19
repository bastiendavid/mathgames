package com.greengames.mathgames.primefactorization.model;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NumberTest {

    @Test
    public void can_find_prime_numbers() throws Exception {
        // Given
        final int primes[] = {1, 2, 3, 7, 13, 23, 47, 53, 97};

        for (int prime : primes) {
            // When
            boolean isPrime = Number.isPrime(prime);
            // Then
            Assertions.assertThat(isPrime).describedAs(String.format("%d should be prime", prime)).isTrue();
        }
    }

    @Test
    public void can_find_not_prime_numbers() throws Exception {
        // Given
        final int notPrimes[] = {4, 8, 10};

        for (int notPrime : notPrimes) {
            // When
            boolean isNotPrime = Number.isPrime(notPrime);
            // Then
            Assertions.assertThat(isNotPrime).describedAs(String.format("%d should not be prime", notPrime)).isFalse();
        }
    }

    @Test
    public void factorize_some_not_prime_number() throws Exception {
        // Given
        final int numberToFactor = 210;
        final List<Integer> expectedFactors = Arrays.asList(2, 3, 5, 7);
        Number number = new Number(1);
        number.setNumber(numberToFactor);

        // When
        number.factorize();
        List<Integer> factors = number.getFactors();

        // Then
        Assertions.assertThat(factors).isEqualTo(expectedFactors);
    }

    @Test
    public void factorize_another_not_prime_number() throws Exception {
        // Given
        final int numberToFactor = 448;
        final List<Integer> expectedFactors = Arrays.asList(2, 2, 2, 2, 2, 2, 7);
        Number number = new Number(1);
        number.setNumber(numberToFactor);

        // When
        number.factorize();
        List<Integer> factors = number.getFactors();

        // Then
        Assertions.assertThat(factors).isEqualTo(expectedFactors);
    }

    @Test
    public void factorize_prime_number() throws Exception {
        // Given
        final int prime = 97;
        Number number = new Number(1);
        number.setNumber(prime);

        // When
        number.factorize();
        List<Integer> factors = number.getFactors();

        // Then
        Assertions.assertThat(factors).containsExactly(prime);
    }

    @Test
    public void factorize_random_number() throws Exception {
        // Given
        Number number = new Number(64000000);

        // When
        List<Integer> factors = number.getFactors();

        // Then
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        Assertions.assertThat(product).isEqualTo(number.getNumber());
    }

    @Test
    public void list_primes_under_number() throws Exception {
        // Given
        final int max = 47;
        final List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);

        // When
        List<Integer> primes = Number.primesUnder(max);

        // Then
        Assertions.assertThat(primes).isEqualTo(expectedPrimes);
    }
}