package dev.wo;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KaratsubaTest {

    @RepeatedTest(value = 10, name = "Teste {currentRepetition} de {totalRepetitions}")
    @DisplayName("O algoritmo obteve o mesmo resultado que a multiplicação comum")
    void algorithmHadTheSameResultAsConventionalMultiplication() {
        BigInteger x = new BigInteger(5000, new Random(System.currentTimeMillis()));
        BigInteger y = new BigInteger(5000, new Random(System.currentTimeMillis()));

        BigInteger resultKaratsuba = Karatsuba.multiply(x, y);
        BigInteger resultTraditional = x.multiply(y);

        assertEquals(resultTraditional, resultKaratsuba);
    }


    /**
     * Existem algumas razões pelas quais o método de Karatsuba pode não ser mais rápido que o método tradicional de multiplicação.
     * Alguns possíveis motivos são:
     *      Tamanho dos números: O método de Karatsuba é mais eficiente em termos de tempo
     *                           quando os números sendo multiplicados são muito grandes.
     *                           Em tamanhos menores, o método tradicional pode ser mais rápido.
     *      Implementação......: A implementação do algoritmo de Karatsuba pode afetar a sua eficiência.
     *                           Alguns algoritmos de multiplicação de Karatsuba são otimizados para tirar
     *                           proveito de recursos específicos do hardware, como instruções de multiplicação
     *                           de alta velocidade, cache de memória e paralelismo.
     *      Overhead...........: Algoritmos de multiplicação de Karatsuba possuem um overhead maior em termos de espaço,
     *                           pois exigem mais memória para armazenar variáveis temporárias do que o método tradicional.
     *                           Isso pode levar a mais operações de leitura e gravação de memória,
     *                           o que pode tornar o método mais lento.
     */
    @Test @DisplayName("O Algoritmo deve ser mais rápido que a multiplicação convencional.")
    void algorithmMustBeFasterThanConventionalMultiplication() {
        BigInteger x = new BigInteger(500000, new Random());
        BigInteger y = new BigInteger(500000, new Random());

        long start = System.nanoTime();
        BigInteger resultKaratsuba = Karatsuba.multiply(x, y);
        long end = System.nanoTime();
        long karatsubaExecutionTime = (end - start);

        start = System.nanoTime();
        BigInteger resultTraditional = x.multiply(y);
        end = System.nanoTime();
        long conventionalMultiplicationExecutionTime = (end - start);

        boolean theAlgorithmIsFaster = karatsubaExecutionTime < conventionalMultiplicationExecutionTime;
        assertTrue(theAlgorithmIsFaster);
    }
}