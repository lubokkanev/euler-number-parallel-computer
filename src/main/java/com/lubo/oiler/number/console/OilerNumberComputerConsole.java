package com.lubo.oiler.number.console;

import com.lubo.oiler.number.core.OilerNumberComputer;

public class OilerNumberComputerConsole {
    private String[] args;
    private Integer numberOfIterations;
    private Integer numberOfThreads;

    public OilerNumberComputerConsole(String[] args) {
        this.args = args;
    }

    public void run() throws InterruptedException {
        parseArgs();
        OilerNumberComputer oilerNumberComputer = new OilerNumberComputer(numberOfIterations,
                numberOfThreads);
        oilerNumberComputer.computeE();

        System.out.println(oilerNumberComputer.getE());
    }

    private void parseArgs() {
        numberOfIterations = 10000;
        numberOfThreads = 1;
    }
}
