package com.sankaran.sairam;

public class QuickSort {
    public static String sortString(StringBuilder string, int p, int r) {
        if (p < r) {
            int q = partitionString(string, p, r);
            sortString(string, p, q-1);
            sortString(string, q+1, r);
        }
        return string.toString();
    }

    private static int partitionString(StringBuilder string, int p, int r) {
        int pivot = r;
        int pivotValue = string.charAt(pivot) - 'a';
        int i=p-1; // i represents boundary of pivot
        for (int j=p; j<r; j++) { // j represents beginning of unexplored territory
           if ((string.charAt(j)-'a') < pivotValue) {
                swapString(string, i + 1, j);
               i = i + 1;
           }
        }
        swapString(string, i + 1, pivot);
        return i+1;
    }

    private static void swapString(StringBuilder string, int i, int j) {
        char chatAtI = string.charAt(i);
        char chatAtJ = string.charAt(j);
        string.setCharAt(i,chatAtJ);
        string.setCharAt(j,chatAtI);
    }
}
