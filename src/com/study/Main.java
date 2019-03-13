package com.study;

import java.math.BigInteger;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final Integer AMOUNT = 500;

    public static void main(String[] args) {

        List<BigInteger> fibonacciSequence = generateFibonacciSequence(AMOUNT);
        fibonacciSequence
                .stream()
                .forEach(System.out::println);
    }

    public static List<BigInteger> generateFibonacciSequence(Integer amountOfFibonacciNumbers) {
        BigInteger[] startingSequence = new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};
        UnaryOperator<BigInteger[]> calculateNext =
                series -> new BigInteger[]{series[1], series[0].add(series[1])};
         return Stream
                .iterate(startingSequence,calculateNext)
                .limit(amountOfFibonacciNumbers)
                .map(series -> series[0])
                .collect(Collectors.toList());
    }
}

