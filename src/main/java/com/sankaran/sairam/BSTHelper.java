package com.sankaran.sairam;

public class BSTHelper {
    public static TreeNode getBSTFromSortedArray(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.setLeft(getBSTFromSortedArray(array, start, mid-1));
        n.setRight(getBSTFromSortedArray(array, mid+1, end));
        return n;
    }
}
