package com.sankaran.sairam;

import java.util.NoSuchElementException;

public class Stack {
    private int size = 0;
    private Node top;

    private void setTop(Node top) {
        this.top = top;
    }

    public boolean isEmpty() {
        return (size < 1);
    }

    public void push(int i) {
        Node top = new Node(i);
        this.size = this.size + 1;
        if (top != null) {
            top.setNext(this.top);
        }
        this.setTop(top);
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
