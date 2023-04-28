package dev.wo;

import java.math.BigInteger;

public class Karatsuba {
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        //Procura o maior número em bits
        int biggerNumberInBits = getBiggerNumberInBits(x, y);
        System.out.println(biggerNumberInBits);

        // Caso base: Se o maior número em bits for menor que 2000, podemos multiplicar convencionalmente.
        if (biggerNumberInBits <= 200) {
            return x.multiply(y);
        }

        biggerNumberInBits = roundUp(biggerNumberInBits);

        //Divide x e y em duas metades de cada variável
        BigInteger rightHalfOfX = x.shiftRight(biggerNumberInBits);
        BigInteger leftHalfOfX = x.subtract(rightHalfOfX.shiftLeft(biggerNumberInBits));
        BigInteger rightHalfOfY = y.shiftRight(biggerNumberInBits);
        BigInteger leftHalfOfY = y.subtract(rightHalfOfY.shiftLeft(biggerNumberInBits));

        // Produto das duas metades de x
        BigInteger productOfTheTwoHalvesOfX = multiply(leftHalfOfX, leftHalfOfY);
        // Produto das duas metades de y
        BigInteger productOfTheTwoHalvesOfY = multiply(rightHalfOfX, rightHalfOfY);
        // Produto das metades de x e y somadas
        BigInteger productOfHalvesOfXAndYAddedTogether = multiply(leftHalfOfX.add(rightHalfOfX), leftHalfOfY.add(rightHalfOfY));

        return productOfTheTwoHalvesOfX
                .add(productOfHalvesOfXAndYAddedTogether
                        .subtract(productOfTheTwoHalvesOfX)
                        .subtract(productOfTheTwoHalvesOfY)
                        .shiftLeft(biggerNumberInBits))
                .add(productOfTheTwoHalvesOfY
                        .shiftLeft(2 * biggerNumberInBits)
                );
    }

    //

    /**
     * Divide o número por dois e adiciona o resto da divisão, para arredondar para cima.
     * @param biggerNumberInBits
     * @return roundedNumber
     */
    private static int roundUp(int biggerNumberInBits) {
        return (biggerNumberInBits / 2) + (biggerNumberInBits % 2);
    }

    private static int getBiggerNumberInBits(BigInteger x, BigInteger y) {
        return Math.max(x.bitLength(), y.bitLength());
    }
}
