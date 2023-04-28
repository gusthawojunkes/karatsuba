package dev.wo;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger result = null;

        BigInteger x = new BigInteger("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");
        BigInteger y = new BigInteger("9876543210987654321098765432109876543210987654321098765432109876543210987654321098765432109876543");

        result = Karatsuba.multiply(x, y);
        System.out.println("Result:" + result);

    }
}