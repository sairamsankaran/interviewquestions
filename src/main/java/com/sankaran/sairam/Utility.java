package com.sankaran.sairam;

public class Utility {
    public static char[] removeSpaces(char[] input, int length) {
        int nextValidIndex = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] != ' ') {
                swap(input, nextValidIndex, i);
                nextValidIndex++;
            }
        }
        return input;
    }

    private static void swap(char[] c, int i, int j) {
        if (i!=j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }
}
