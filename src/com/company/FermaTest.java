package com.company;

import java.math.BigInteger;
import java.util.Random;

public class FermaTest {

    private final static Random rand = new Random();

    private static BigInteger getRandomFermatBase(BigInteger n) {
        while (true) {
            final BigInteger a = new BigInteger (n.bitLength(), rand);
            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0) {
                return a;
            }
        }
    }

    public static boolean checkPrime(BigInteger n, int maxIterations)
    {
        if (n.equals(BigInteger.ONE))
            return false;

        for (int i = 0; i < maxIterations; i++) {
            BigInteger a = getRandomFermatBase(n);
            BigInteger b = a.modPow(n.subtract(BigInteger.ONE), n); // b = a^n-1 % n

            if (!a.equals(BigInteger.ONE))
                return false;
        }

        return true;
    }

    public static void main(Object o) {
        System.out.printf("checkprime(2)  %b\n", checkPrime(BigInteger.valueOf(2), 20));
        System.out.printf("checkprime(5)  %b\n", checkPrime(BigInteger.valueOf(5), 20));
        System.out.printf("checkprime(7)  %b\n", checkPrime(BigInteger.valueOf(7), 20));
        System.out.printf("checkprime(9)  %b\n", checkPrime(BigInteger.valueOf(9), 20));
    }
}