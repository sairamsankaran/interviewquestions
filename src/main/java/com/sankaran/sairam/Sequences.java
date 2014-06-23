package com.sankaran.sairam;

/**
 * Created by sairamsankaran on 6/22/14.
 */
public class Sequences {

    public int largestSum(int[] sequence) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum = sum + sequence[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
