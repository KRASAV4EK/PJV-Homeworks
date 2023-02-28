package cz.cvut.fel.pjv;

import java.io.*;
import java.util.Objects;
import java.math.*;

public class Lab02 {
    public void start(String[] args) {
        homework();
    }
    private void homework() {

        // create new TextIO object
        TextIO textIO = new TextIO();

        // set some variables
        int lineCounter = 0;
        double sum = 0;
        int numCounter = 0;
        double partialSum = 0;
        double partialSumSquares = 0;

        // cycle for reading information from file
        while (textIO.stdin.hasNext()) {
            // get info from the line
            String line = textIO.getLine();
            // check if input is a number
            if (TextIO.isDouble(line))
            {
                // check if 10 numbers were already added and print
                if (numCounter == 10) {
                    printMeanDeviation(partialSum, partialSumSquares, numCounter, sum);

                    sum = 0;
                    numCounter = 0;
                    partialSum = 0;
                    partialSumSquares = 0;
                }
                // add new number
                double number = Double.parseDouble(line);
                sum += number;
                partialSum += number;
                partialSumSquares += Math.pow(number, 2);
                lineCounter++;
                numCounter++;
            } else {
                // check if 10 numbers were already added and print
                if (numCounter == 10) {
                    printMeanDeviation(partialSum, partialSumSquares, numCounter, sum);

                    sum = 0;
                    numCounter = 0;
                    partialSum = 0;
                    partialSumSquares = 0;
                }

                System.err.println("A number has not been parsed from line " + ++lineCounter);
            }

            // check  the end was achieved
            if (!textIO.stdin.hasNext()) {
                // check if any numbers were added
                if (numCounter != 0) {

                    // print error message and check if was added only one number
                    if (numCounter != 10) {
                        System.err.println("End of input detected!");
                    }
                    if (numCounter == 1) {
                        return;
                    }

                    printMeanDeviation(partialSum, partialSumSquares, numCounter, sum);

                    if (numCounter == 10) {
                        System.err.println("End of input detected!");
                    }
                }
            }
        }
    }
    private double getDeviation(double partialSum, double partialSumSquares,
                                double numCounter) {
        return Math.sqrt((partialSumSquares - Math.pow(partialSum, 2) / numCounter) / (numCounter));
    }
    private void printMeanDeviation(double partialSum, double partialSumSquares,
                                    int numCounter, double sum) {
        double deviation = getDeviation(partialSum, partialSumSquares, numCounter);
        double mean = sum / numCounter;
        System.out.printf("%2d %.3f %.3f\n", numCounter, mean, deviation);
    }
}