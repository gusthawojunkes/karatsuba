package dev.wo;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigInteger result = null;

        BigInteger x = new BigInteger(50, new Random());
        BigInteger y = new BigInteger(50, new Random());

        result = Karatsuba.multiply(x, y);
        System.out.println("Result:" + result);

    }
}