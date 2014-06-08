package com.sankaran.sairam;

import java.util.NoSuchElementException;

public class Stack {
    private final int MAX_SIZE = 10;
    private int size = 0;
    private Node top;

    private void setTop(Node top) {
        this.top = top;
    }

    public boolean isEmpty() {
        return (size < 1);
    }

    public boolean push(int i) {
        if (this.size + 1 > MAX_SIZE) {
            System.out.println("Stack if full!");
            return false;
        }
        Node top = new Node(i);
        this.size = this.size + 1;
        if (this.top != null) {
            top.setNext(this.top);
        }
        this.setTop(top);
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node top = this.top;
        this.setTop(top.getNext());
        this.size = this.size - 1;
        return top.getKey();
    }

    public int peek() {
        return this.top.getKey();
    }

    public void print() {
        Node node = this.top;
        while (node != null) {
            System.out.println(node.getKey());
            node = node.getNext();
        }
    }
}
