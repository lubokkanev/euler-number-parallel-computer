package com.lubo.oiler.number.console;

import com.lubo.oiler.number.core.OilerNumberComputer;

public class OilerNumberComputerConsole {
    private String[] args;
    private Integer numberOfIterations;
    private Integer numberOfThreads;

    public OilerNumberComputerConsole(String[] args) {
        this.args = args;
    }

    public void compute() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        parseArgs();
        OilerNumberComputer oilerNumberComputer = new OilerNumberComputer(numberOfIterations,
                numberOfThreads);
        oilerNumberComputer.computeE();

        System.out.println("Oiler number e = " + oilerNumberComputer.getE());

        long endTime   = System.currentTimeMillis();
        double totalTimeInMills = (endTime - startTime) / 1000.0;
        System.out.println("The program finished in " + totalTimeInMills + " second(s) with " +
                numberOfThreads +
                " threads. ");
    }

    private void parseArgs() {
        numberOfIterations = Integer.parseInt(args[1]);
        numberOfThreads = Integer.parseInt(args[0]);
    }
}
