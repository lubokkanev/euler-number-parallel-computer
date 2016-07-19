package com.lubokkanev.euler.number.core;

import com.lubokkanev.euler.number.util.RuntimeCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static com.lubokkanev.euler.number.core.Defaults.QUIET_MODE_STATE;

public class EulerNumberComputer {
    private BigDecimal e = new BigDecimal(0);

    private final int NUMBER_OF_DIGITS;
    private final int NUMBER_OF_ITERATIONS;
    private final int NUMBER_OF_THREADS;
    private final boolean IN_QUIET_MODE;

    public EulerNumberComputer(Integer numberOfIterations, Integer numberOfThreads, Boolean inQuietMode, Integer numberOfDigits) {
        NUMBER_OF_DIGITS = numberOfDigits == null ? Defaults.NUMBER_OF_DIGITS : numberOfDigits;
        NUMBER_OF_ITERATIONS = numberOfIterations == null ? Defaults.NUMBER_OF_ITERATIONS : numberOfIterations;
        NUMBER_OF_THREADS = numberOfThreads == null ? Defaults.NUMBER_OF_THREADS : numberOfThreads;
        IN_QUIET_MODE = inQuietMode == null ? QUIET_MODE_STATE : inQuietMode;
    }

    public BigDecimal getE() {
        return e;
    }

    public void computeE() {
        ArrayList<PartialSumComputer> threads = new ArrayList<PartialSumComputer>();

        for (int i = 0; i < NUMBER_OF_THREADS; ++i) {
            PartialSumComputer thread = new PartialSumComputer(i, NUMBER_OF_THREADS, i + 1, IN_QUIET_MODE);
            threads.add(thread);
            thread.start();
        }

        for (PartialSumComputer thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e1) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private BigDecimal computationalFunction(int k) {
        return BigDecimal.valueOf(Math.pow(3 * k, 2) + 1).divide(factorial(3 * k), NUMBER_OF_DIGITS, RoundingMode.HALF_EVEN);
    }

    private BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;

        for (int i = 2; i <= n; ++i) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        return result;
    }

    private class PartialSumComputer extends Thread {
        private final int step;
        private final int start;
        private final int threadNumber;
        private final boolean inQuietMode;
        private RuntimeCalculator runtimeCalculator;
        private BigDecimal partialSum;

        public PartialSumComputer(int start, int end, int threadNumber, boolean inQuietMode) {
            this.start = start;
            this.step = end;
            this.threadNumber = threadNumber;
            this.inQuietMode = inQuietMode;
        }

        @Override
        public void run() {
            setStartTime();
            printStartingMessage();
            addPartialSum();
            printEndMessage();
            setEndTime();
            printThreadRunningTime();
        }

        private void addPartialSum() {
            computePartialSum();
            e = e.add(partialSum);
        }

        private void computePartialSum() {
            partialSum = BigDecimal.ZERO;
            for (int i = start; i < NUMBER_OF_ITERATIONS; i += step) {
                partialSum = partialSum.add(computationalFunction(i));
            }
        }

        private void printThreadRunningTime() {
            if (!inQuietMode) {
                System.out.println("Thread " + threadNumber + " execution time was " + runtimeCalculator.getRuntimeInSeconds() + " " + "seconds.");
            }
        }

        private void setEndTime() {
            runtimeCalculator.setEndTime(System.currentTimeMillis());
        }

        private void setStartTime() {
            runtimeCalculator = new RuntimeCalculator(System.currentTimeMillis());
        }

        private void printEndMessage() {
            if (!inQuietMode) {
                System.out.println("Thread " + threadNumber + " finished.");
            }
        }

        private void printStartingMessage() {
            if (!inQuietMode) {
                System.out.println("Thread " + threadNumber + " started.");
            }
        }
    }
}

