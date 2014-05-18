package com.sankaran.sairam;

import java.util.NoSuchElementException;

public class Queue {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return (tail == null);
    }

    public void enqueue(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public Node dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = this.head;
        this.head = node.getNext();
        return node;
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.getKey());
            if (node.getNext() != null) {
                System.out.print(" ");
            }
            node = node.getNext();
        }
    }
}

