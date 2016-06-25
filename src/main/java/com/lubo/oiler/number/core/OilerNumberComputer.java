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
        long startTime = System.currentTimeMillis();

        int piece = (int) Math.ceil(new Double(numberOfIterations) / numberOfThreads);
        int remaining = numberOfIterations - piece * (numberOfThreads - 1);

        ArrayList<MyThread> threads = new ArrayList<MyThread>();

        for (int i = 0; i < numberOfThreads - 1; ++i) {
            MyThread thread = new MyThread(i * piece, i * piece + piece, i + 1);
            threads.add(thread);
            thread.start();
        }

        MyThread thread = new MyThread(numberOfIterations - remaining, numberOfIterations,
                numberOfThreads);
        thread.start();
        threads.add(thread);

        for (int i = 0; i < threads.size(); ++i) {
            threads.get(i).join();
        }

        long endTime   = System.currentTimeMillis();
        double totalTimeInMills = (endTime - startTime) / 1000.0;
        System.out.println("The program finished in " + totalTimeInMills + " second(s) with " + 2 +
                " threads. ");
    }

    private class MyThread extends Thread {
        private final int end;
        private final int start;
        private final int number;

        public MyThread(int start, int end, int number) {
            this.start = start;
            this.end = end;
            this.number = number;
        }

        @Override
        public void run() {
            printStartingMessage();

            BigDecimal currentResult = BigDecimal.ZERO;

            for (int i = start; i < end; ++i) {
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
