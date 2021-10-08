/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats {


    //intializations
    private double[] summation;
    private int totalSites;
    private int instanceCount;




    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid


        Stopwatch globalTime = new Stopwatch();
        summation = new double[T];
        totalSites = N * N;
        instanceCount = T;


        //START THE TEST LOOPS
        for (int i = 0; i < T; i++) {

            Stopwatch timer = new Stopwatch(); //START THE TIMER
            Percolation percolationInstance = new Percolation(N);

            int sitesOpen = 0;


            //while instance does not percolate
            while (!percolationInstance.percolates()) {
                int randomCol = StdRandom.uniform(N);
                int randomRow = StdRandom.uniform(N);
                percolationInstance.open(randomCol, randomRow);


                //if instance percolates
                if (percolationInstance.percolates()) {
                    //collect each number of sites for standard deviation later
                    summation[i] = (double) percolationInstance.numberOfOpenSites();

                    break;
                }

            } //end of each instance



        } //end of all instances


        //basically return everything
        System.out.println();


        System.out.println("Mean: " + mean(summation) );
        System.out.println("Standard Deviation " + stddev(summation) );
        System.out.println("High Confidence " + confidenceHigh(summation) );
        System.out.println("Low Confidence " + confidenceLow(summation) );
        System.out.println(globalTime.elapsedTime() + " Global Seconds");
        System.out.println( "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-");

    }



    public double mean(double[] array) {
        // sample mean of percolation threshold
        double summation = 0.0;
        double realMean = 0.0;
        int count = array.length;

        for (int i = 0; i < count; i++)
            summation += array[i]; //summate all values

        realMean = summation / count; //acquire the mean


        return realMean / totalSites;
    }


    //something wrong here
    public double stddev(double[] array) {
        // sample standard deviation of percolation threshold
        double trueStandardDeviation = 0.0;


        trueStandardDeviation = StdStats.stddev(array);

        return trueStandardDeviation / totalSites;
    }


    public double confidenceLow(double[] array) {
        // low  endpoint of 95% confidence interval
        double conflow = 0.0;

        conflow = mean(array) - (1.96 * stddev( array ) ) / Math.sqrt(instanceCount);

        return conflow;
    }



    public double confidenceHigh(double[] array) {
        // high endpoint of 95% confidence interval
        double confHigh = 0.0;

        confHigh = mean(array) + (1.96 * stddev( array ) ) / Math.sqrt(instanceCount);

        return confHigh;
    }




    public static void main(String[] args) {
        // Not required for the API, but useful to test if
        // your code is doing reasonable things
        //N = DIMENSIONS
        //T = # OF INSTANCES


        PercolationStats st = new PercolationStats(500,100);



    }
}