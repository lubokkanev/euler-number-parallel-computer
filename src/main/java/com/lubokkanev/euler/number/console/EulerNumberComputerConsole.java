package com.lubokkanev.euler.number.console;

import com.lubokkanev.euler.number.core.Defaults;
import com.lubokkanev.euler.number.core.EulerNumberComputer;
import com.lubokkanev.euler.number.util.RuntimeCalculator;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EulerNumberComputerConsole {
    private String[] args;

    private EulerNumberComputer eulerNumberComputer;

    private Integer numberOfDigits;
    private Integer numberOfIterations;
    private Integer numberOfThreads;
    private Boolean inQuietMode;
    private String outputFile;
    private Printer printer = new Printer();

    private RuntimeCalculator runtimeCalculator = new RuntimeCalculator();

    public EulerNumberComputerConsole(String[] args) {
        this.args = args;
    }

    public void run() {
        setStartTime();
        parseArgs();
        computeEulerNumber();
        setEndTime();
        printer.printSummary();
    }

    private void computeEulerNumber() {
        eulerNumberComputer = new EulerNumberComputer(numberOfIterations, numberOfThreads, inQuietMode, numberOfDigits);

        eulerNumberComputer.computeE();
    }

    private void setEndTime() {
        runtimeCalculator.setEndTime(System.currentTimeMillis());
    }

    private void setStartTime() {
        runtimeCalculator.setStartTime(System.currentTimeMillis());
    }

    private void parseArgs() {
        DefaultParser parser = new DefaultParser();
        Options options = new Options();

        options.addOption("d", true, "number of digits");
        options.addOption("p", true, "number of iterations");
        options.addOption("t", "tasks", true, "number of parallel tasks");
        options.addOption("q", false, "quiet mode");
        options.addOption("o", true, "output file");

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("p")) {
                numberOfIterations = Integer.parseInt(cmd.getOptionValue("p"));
            } else {
                numberOfIterations = Defaults.NUMBER_OF_ITERATIONS;
            }

            if (cmd.hasOption("t")) {
                numberOfThreads = Integer.parseInt(cmd.getOptionValue("t"));
            } else {
                numberOfThreads = Defaults.NUMBER_OF_THREADS;
            }

            if (cmd.hasOption("q")) {
                inQuietMode = true;
            } else {
                inQuietMode = Defaults.QUIET_MODE_STATE;
            }

            if (cmd.hasOption("o")) {
                outputFile = cmd.getOptionValue("o");
            } else {
                outputFile = Defaults.OUTPUT_FILE;
            }

            if (cmd.hasOption("d") && validNumberOfDigits(Integer.valueOf(cmd.getOptionValue("d")))) {
                numberOfDigits = Integer.valueOf(cmd.getOptionValue("d"));
            } else {
                numberOfDigits = Defaults.NUMBER_OF_DIGITS;
            }
        } catch (ParseException e) {
            System.err.println("Could not parse arguments. Using default settings. ");
        }
    }

    private boolean validNumberOfDigits(int numberOfDigits) {
        return numberOfDigits >= 0;
    }

    private class Printer {
        private final String E_PRINT_MESSAGE = "The value of the Euler's number is %s. ";

        public void printSummary() {
            printSeparator();
            printEulerNumber();
            writeEulerNumberToFile();

            if (!inQuietMode) {
                printSeparator();
                printDigitsPrinted();
                printThreadsUsed();
                printIterationsDone();
                printTotalTime();
            }
        }

        private void printDigitsPrinted() {
            System.out.println("Printed " + numberOfDigits + " digits. ");
        }

        private void printSeparator() {
            System.out.println();
        }

        private void printEulerNumber() {
            System.out.println(String.format(E_PRINT_MESSAGE, eulerNumberComputer.getE()));
        }

        private void printThreadsUsed() {
            System.out.println("Used " + numberOfThreads + " threads.");
        }

        private void printIterationsDone() {
            System.out.println("Did " + numberOfIterations + " iterations.");
        }

        private void printTotalTime() {
            System.out.println("The total execution time was " + runtimeCalculator.getRuntimeInSeconds() + " seconds.");
        }

        private void writeEulerNumberToFile() {
            try (PrintWriter writer = new PrintWriter(outputFile, "UTF-8")) {
                writer.println(String.format(E_PRINT_MESSAGE, eulerNumberComputer.getE()));
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                System.err.println("Could not create the output  file. ");
            }
        }
    }
}
