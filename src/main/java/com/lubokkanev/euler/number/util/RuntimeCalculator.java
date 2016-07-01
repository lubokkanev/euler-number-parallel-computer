package com.lubokkanev.euler.number.util;

public class RuntimeCalculator {
    private long startTime;
    private long endTime;

    public RuntimeCalculator() {

    }

    public RuntimeCalculator(long startTime) {
        this.startTime = startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getRuntimeInSeconds() {
        return (double) (endTime - startTime) / 1000;
    }
}
