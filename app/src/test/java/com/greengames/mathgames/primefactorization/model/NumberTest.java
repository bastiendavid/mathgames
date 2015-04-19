package com.greengames.mathgames.primefactorization.model;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

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
}