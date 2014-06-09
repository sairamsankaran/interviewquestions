package com.sankaran.sairam;

import java.util.ArrayList;

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

    public TreeNode deleteNode(TreeNode z) {
        TreeNode y; // node to be spliced
        TreeNode x; // child of spliced node which gets orphaned
        if ((z.getLeft() == null) || (z.getRight() == null)) {
            y = z;
        } else {
            y = successor(z);
        }
        if (y.getLeft() == null) {
            x = y.getRight();
        } else {
            x = y.getLeft();
        }
        if (x != null) {
            x.setParent(y.getParent());
        }
        if (y.getParent() == null) {
            this.root = x;
        } else {
            if (y.equals(y.getParent().getLeft())) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
        }
        if (!y.equals(z)) { // spliced successor
            z.setKey(y.getKey());
        }
        return y;
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
        if (node.getRight() != null) {
            TreeNode x = node.getRight();
            while (x.getLeft() != null) {
                x = x.getLeft();
            }
            return x;
        }
        TreeNode x = node;
        TreeNode y = x.getParent();
        // stop when child is left node of parent
        while (y != null && x.equals(y.getRight())) {
            x = y;
            y = x.getParent();
        }
        return y;
    }

    public void print() {

    }

    private int minDepthFromNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (1 + Math.min(minDepthFromNode(node.getLeft()), minDepthFromNode(node.getRight())));
    }

    private int maxDepthFromNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (1 + Math.max(maxDepthFromNode(node.getLeft()), maxDepthFromNode(node.getRight())));
    }

    public boolean isBalanced() {
        return ((maxDepthFromNode(this.root) - minDepthFromNode(this.root)) <= 1);
    }

    private void printNode(TreeNode node) {
        System.out.print(node.getKey());
    }

}
