package com.sankaran.sairam;

public class LinkedList {
    private Node head = null;

    public LinkedList() {

    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(String value) {
        Node head = new Node(value);
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addNode(Node node) {
        if (this.head != null) {
            node.setNext(this.head);
            this.head.setPrev(node);
        }
        this.head = node;
    }

    public void deleteNode(Node node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            this.head = node.getNext();
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void addValue(String value) {
        Node newNode = new Node(value);
        if (this.head != null) {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
        }
        this.head = newNode;
    }

    public void deleteValue(String value) {
        Node node = search(value);
        // if value found. We need to check here because,
        // if not found it will return head or null
        if (node != null && node.getValue().equals(value)){
            if (node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            } else {
                this.head = node.getNext();
            }
            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            }
        }

    }

    public Node search(String value) {
        Node node = this.head;
        while (node != null && !node.getValue().equals(value)) {
            node = node.getNext();
        }
        return node;
    }

    public void reverse() {
        Node node = this.head;
        Node prev = null;
        Node next = null;
        while (node != null) {
            next = node.getNext();
            prev = node.getPrev();
            node.setNext(prev);
            node.setPrev(next);
            prev = node;
            node = next;
        }
        this.head = prev;
    }

    public static Node reverseRecursively(Node node, Node prev) {
        if (node == null) { // empty list
            return null;
        }
        if (node.getNext() == null) { // last node to process
            node.setNext(prev);
            return node; // new head
        }
        Node next = node.getNext();
        node.setNext(prev);
        node.setPrev(next);
        prev = node;
        Node head = reverseRecursively(next, prev);
        return head; // new head
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
    }
}
