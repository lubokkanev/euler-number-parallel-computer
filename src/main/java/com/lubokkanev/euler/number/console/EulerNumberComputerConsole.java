package com.lubokkanev.euler.number.console;

import com.lubokkanev.euler.number.core.EulerNumberComputer;
import com.lubokkanev.euler.number.util.RuntimeCalculator;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EulerNumberComputerConsole {
    private String[] args;

    private EulerNumberComputer eulerNumberComputer;

    private Integer numberOfIterations;
    private Integer numberOfThreads;
    private Boolean inQuietMode;
    private String outputFile = "output.txt";
    private Printer printer = new Printer();

    private RuntimeCalculator runtimeCalculator;

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
        eulerNumberComputer = new EulerNumberComputer(numberOfIterations, numberOfThreads,
                inQuietMode);

        eulerNumberComputer.computeE();
    }

    private void setEndTime() {
        runtimeCalculator.setEndTime(System.currentTimeMillis());
    }

    private void setStartTime() {
        runtimeCalculator = new RuntimeCalculator(System.currentTimeMillis());
    }

    private void parseArgs() {
        DefaultParser parser = new DefaultParser();
        Options options = new Options();

        options.addOption("p", true, "number of iterations");
        options.addOption("t", "tasks", true, "number of parallel tasks");
        options.addOption("q", false, "quiet mode");
        options.addOption("o", true, "output file");

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("p")) {
                numberOfIterations = Integer.parseInt(cmd.getOptionValue("p"));
            }

            if (cmd.hasOption("t")) {
                numberOfThreads = Integer.parseInt(cmd.getOptionValue("t"));
            }

            if (cmd.hasOption("q")) {
                inQuietMode = true;
            }

            if (cmd.hasOption("o")) {
                outputFile = cmd.getOptionValue("o");
            }
        } catch (ParseException e) {
            System.err.println("Could not parse arguments. Using default settings. ");
        }
    }

    class Printer {
        private final String E_PRINT_MESSAGE = "The value of the Euler's number is %s. ";

        public void printSummary() {
            printSeparator();
            printEulerNumber();
            writeEulerNumberToFile();

            if (inQuietMode == null) {
                printSeparator();
                printThreadsUsed();
                printIterationsDone();
                printTotalTime();
            }
        }

        private void printSeparator() {
            System.out.println();
        }

        private void printEulerNumber() {
            System.out.println(String.format(E_PRINT_MESSAGE, eulerNumberComputer.getE()));
        }

        private void printThreadsUsed() {
            System.out.println("Used " + numberOfThreads + " threads in the current run.");
        }

        private void printIterationsDone() {
            System.out.println("Did " + numberOfIterations + " iterations in the current run.");
        }

        private void printTotalTime() {
            System.out.println("The total execution time for current run was " +
                    runtimeCalculator.getRuntimeInSeconds() + " seconds.");
        }

        private void writeEulerNumberToFile() {
            try (PrintWriter writer = new PrintWriter(outputFile, "UTF-8")){
                writer.println(String.format(E_PRINT_MESSAGE, eulerNumberComputer.getE()));
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                System.err.println("Could not create the output  file. ");
            }
        }
    }
}