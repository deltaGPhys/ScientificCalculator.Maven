package com.zipcodewilmington.scientificcalculator;

import java.util.Arrays;

public class Statistics1Var {

    private Double[] data;
    private Double mean;
    private Double median;
    private Double min;
    private Double max;
    private Double stdDev;
    private Double var;
    private Integer n;
    private String output;

    public Statistics1Var() {

        this.data = new Double[]{};
        this.mean = null;
        this.median = null;
        this.min = null;
        this.max = null;
        this.stdDev = null;
        this.var = null;
        this.n = 0;
        this.output = "No data entered";
    }

    // Getters
    public Double[] getData() {
        return data;
    }

    public Double getMedian() {
        return median;
    }

    public Double getStdDev() {
        return stdDev;
    }

    public Double getVar() {
        return var;
    }

    public Integer getN() {
        return n;
    }

    public String getOutput() {
        return output;
    }

    public Double getMean() {
        return mean;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    // Setter

    public void setData(Double[] data) {
        this.data = data;
        this.calculateStatistics();
    }

    // Core logic

    public String calculateStatistics() {

        this.mean = this.calcMean();
        this.median = this.calcMedian();
        this.min = this.calcMin();
        this.max = this.calcMax();
        this.stdDev = null;
        this.var = null;
        this.n = data.length;
        this.output = "1-Variable Statistics:\n" +
                "n: " + Double.toString(this.n) + "\n" +
                "Mean: " + Double.toString(this.mean) +"\n" +
                "Median: " + Double.toString(this.median) +"\n" +
                "Min: " + Double.toString(this.min) +"\n" +
                "Max: " + Double.toString(this.max) +"\n" +
                "Std Dev: " + Double.toString(this.stdDev) +"\n" +
                "Var: " + Double.toString(this.var);

        return output;
    }

    public Double calcMean() {
        if (data.length > 0) {
            Double total = 0.0;
            for (Double datum : data) {
                total += datum;
            }
            return total / data.length;
        } else {
            return null;
        }
    }

    public Double calcMedian() {
        Arrays.sort(data);
        Integer n = data.length;
        if (n % 2 == 0) {
            return (data[n / 2] + data[n / 2 - 1]) / 2;
        } else {
            return data[n/2];
        }
    }

    public Double calcMin() {
        Arrays.sort(data);
        return data[0];
    }

    public Double calcMax() {
        Arrays.sort(data);
        return data[data.length-1];
    }
}