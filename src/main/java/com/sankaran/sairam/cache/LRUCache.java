package com.sankaran.sairam.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sairamsankaran on 9/16/14.
 */
public class LRUCache {
    Map<Integer, Node<Integer>> cache = new HashMap<Integer, Node<Integer>>();
    DoublyLinkedList<Integer> list;
    int size = 0;
    int capacity = 1000;

    public LRUCache() {
        list = new DoublyLinkedList<Integer>(this.capacity);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoublyLinkedList<Integer>(this.capacity);
    }

    public int get(int key) {
        Node<Integer> i = cache.get(key);
        if(i == null){
            return -1;
        } else {
            list.remove(i);
            list.insert(i);
            return i.getItem();
        }
    }

    public void set(int key, int value) {
        Node<Integer> i = cache.get(key);
        if(i == null){
            i = new Node<Integer>(key, value);
            cache.put(key, i);
            list.insert(i);
        } else {
            i.setItem(value);
            list.remove(i);
            list.insert(i);
        }
    }

    public class DoublyLinkedList<T> {
        private Node<T> head = null;
        private Node<T> tail = null;
        int size = 0;
        int capacity = 0;

        public DoublyLinkedList() {

        }

        public DoublyLinkedList(int capacity) {
            this.capacity = capacity;
        }

        public Node getHead() {
            return this.head;
        }

        public Node getTail() {
            return this.tail;
        }

        public void insert(Node node) {
            // always insert as the head
            if(this.size + 1 > this.capacity) {
                removeTail();
                insert(node);
                return;
            } else {
                if(this.head == null) {
                    this.head = node;
                    this.tail = node;
                    this.size++;
                } else {
                    node.setNext(this.head);
                    head.setPrev(node);
                    this.head = node;
                    this.size++;
                }
                return;
            }
        }

        public boolean remove(Node node) {
            if(node == null) {
                return false;
            }
            if(node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            } else {
                this.tail = node.getPrev();
            }
            if(node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            } else {
                this.head = node.getNext();
            }
            this.size--;
            if(this.size < 1) {
                this.head = null;
            }
            node.setNext(null);
            node.setPrev(null);
            return true;
        }

        public boolean removeTail() {
            if(this.size > 0 && this.tail != null) {
                Node node = this.tail;
                this.tail = node.getPrev();
                if(this.tail != null) {
                    this.tail.setNext(null);
                }
                node.setPrev(null);
                cache.remove(node.getKey());
                this.size--;
                if(this.size < 1) {
                    this.head = null;
                }
                return true;
            }
            return false;
        }
    }

    public class Node<T> {
        private int key;
        private T item;
        private Node<T> prev;
        private Node<T> next;

        public Node(int key, T item) {
            this.key = key;
            this.item = item;
        }

        public T getItem() {
            return this.item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }
    }
}
