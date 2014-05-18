package com.sankaran.sairam;

public class LinkedList {
    private Node head = null;

    public LinkedList() {

    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(int key) {
        Node head = new Node(key);
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insertNode(Node node) {
        // adds the new node as head
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

    public void insertKey(int key) {
        // adds the new key as head
        Node newNode = new Node(key);
        if (this.head != null) {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
        }
        this.head = newNode;
    }

    public void deleteKey(int key) {
        Node node = search(key);
        // if key found. We need to check here because,
        // if not found, node will be head or null
        if (node != null && (node.getKey() == key)){
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

    public Node search(int key) {
        Node node = this.head;
        while (node != null && (node.getKey() != key)) {
            node = node.getNext();
        }
        return node;
    }

    public void reverse() {
        // by iteration
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

    public static Node reverse(Node node, Node prev) {
        // by recursion
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
        Node head = reverse(next, prev);
        return head; // new head
    }

    public void print() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.getKey());
            if (node.getNext() != null) {
                System.out.print("->");
            }
            node = node.getNext();
        }
    }
}
