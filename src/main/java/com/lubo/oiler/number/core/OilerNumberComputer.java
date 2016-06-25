package com.lubo.oiler.number.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OilerNumberComputer {
    private final Integer numberOfIterations;
    private final Integer numberOfThreads;
    private volatile BigDecimal e;
    private ArrayList<BigInteger> preCalculatedFactorials;

    public OilerNumberComputer(Integer numberOfIterations, Integer numberOfThreads) {
        e = new BigDecimal(0);
        this.numberOfIterations = numberOfIterations;
        this.numberOfThreads = numberOfThreads;
        preCalculatedFactorials = new ArrayList<BigInteger>(3 * numberOfIterations + 1);
        //preCalculateFactorials();
    }

    private void preCalculateFactorials() {
        preCalculatedFactorials.add(BigInteger.ONE);
        for (int i = 1 ;i < 3 * numberOfIterations + 1; ++i) {
            preCalculatedFactorials.add(preCalculatedFactorials.get(i - 1).multiply(BigInteger
                    .valueOf(i)));
        }
    }

    public BigDecimal getE() {
        return e;
    }

    public void computeE() throws InterruptedException {
        ArrayList<MyThread> threads = new ArrayList<MyThread>();

        for (int i = 0; i < numberOfThreads; ++i) {
            MyThread thread = new MyThread(i, numberOfThreads, i + 1);
            threads.add(thread);
            thread.start();
        }

        for (MyThread thread : threads) {
            thread.join();
        }
    }

    private class MyThread extends Thread {
        private final int step;
        private final int start;
        private final int number;

        public MyThread(int start, int end, int number) {
            this.start = start;
            this.step = end;
            this.number = number;
        }

        @Override
        public void run() {
            printStartingMessage();

            BigDecimal currentResult = BigDecimal.ZERO;

            for (int i = start; i < numberOfIterations; i += step) {
                currentResult = currentResult.add(computationalFunction(i));
            }

            e = e.add(currentResult);
            printEndMessage();
        }

        private void printEndMessage() {
            System.out.println("Thread number " + number + " finished.");
        }

        private void printStartingMessage() {
            System.out.println("Thread number " + number + " starting...");
        }
    }

    private BigDecimal computationalFunction(int k) {
        return BigDecimal.valueOf(Math.pow(3 * k, 2) + 1).divide(factorialSlow(3 * k), 20,
                RoundingMode.CEILING);
    }

    private BigDecimal factorialSlow(int n) {
        BigDecimal result = BigDecimal.ONE;

        for (int i = 2; i <= n; ++i) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        return result;
    }

    private BigDecimal factorial(int n) {
        return new BigDecimal(preCalculatedFactorials.get(n));
    }
}
