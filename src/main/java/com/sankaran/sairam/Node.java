package com.sankaran.sairam;

public class Node {
    private int key;
    // private String value = null; // not implementing this for now
    private Node next = null;
    private Node prev = null;

    public Node() {

    }

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public boolean isHead() {
        return (this.getPrev() == null);
    }

    public boolean isTail() {
        return (this.getNext() == null);
    }

    /*
    A node is single if both its prev and next
    pointers are null
     */
    public boolean isSingle() {
        return (this.isHead() && this.isTail());
    }
}