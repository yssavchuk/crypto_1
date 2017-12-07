package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class BinaryPower {

    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BigInteger numb = new BigInteger("332134423244566");

        BigInteger deg = new BigInteger("101");

        BigInteger mod = new BigInteger("33");

        System.out.println(numb + " ^ " + deg + "(mod " + deg + " ) =" + binpow(numb, deg).mod(mod));
    }

    private static BigInteger binpow(BigInteger a, BigInteger n) {
        if (n.equals(ZERO)) {
            return BigInteger.ONE;
        }
        if (n.mod(TWO).equals(ONE)) {
            return a.multiply(binpow(a, n.subtract(ONE)));
        } else {
            BigInteger b = binpow(a, n.divide(TWO));
            return b.multiply(b);
        }
    }
}
