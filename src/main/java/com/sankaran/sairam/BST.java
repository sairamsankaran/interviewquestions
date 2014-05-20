package com.sankaran.sairam;

public class BST {
    private TreeNode root = null;

    public void insertNode(TreeNode node) {
        TreeNode x = this.root;
        TreeNode y = null; // parent of x

        while (x != null) {
            y = x;
            if (node.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        node.setParent(y);

        if (y == null) { // empty tree
            this.root = node;
            return;
        } else {
            if (node.getKey() < y.getKey()) {
                y.setLeft(node);
            } else {
                y.setRight(node);
            }
        }
    }

    public void deleteNode(TreeNode node) {

    }

    public void preOderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        printNode(node);
        preOderTraversal(node.getLeft());
        preOderTraversal(node.getRight());
    }

    public void inOderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOderTraversal(node.getLeft());
        printNode(node);
        inOderTraversal(node.getRight());
    }

    public void postOderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOderTraversal(node.getLeft());
        postOderTraversal(node.getRight());
        printNode(node);
    }

    public TreeNode search(int key) {
        TreeNode node = new TreeNode(key);
        TreeNode x = this.root;
        while (x != null && (x.getKey() != node.getKey())) {
            if (node.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x; // if key not found, this could return root or null
    }

    public TreeNode getMin() {
        TreeNode x = this.root;
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    public TreeNode getMax() {
        TreeNode x = this.root;
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    public TreeNode successor(TreeNode node) {
        return new TreeNode();
    }

    public void print() {

    }

    private void printNode(TreeNode node) {
        System.out.print(node.getKey());
    }
}
