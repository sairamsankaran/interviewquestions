package com.sankaran.sairam;

public class MaxHeap {
    private final int INT_MIN = -1000; // some very small int

    private int size; // heapSize
    private Node[] data;

    public MaxHeap(Node[] array) {
        buildHeap(array);
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return 2*i + 2;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    // restore heap property
    private void heapify(int index) {
        int largest = index;
        int l = left(index);
        int r = right(index);
        if (l < size && this.data[l].getKey() > this.data[largest].getKey()) {
            largest = l;
        }
        if (r < size && this.data[r].getKey() > this.data[largest].getKey()) {
            largest = r;
        }
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    private void buildHeap(Node[] array) {
        this.size = array.length;
        this.data = array;
        // leaves are already in correct index
        for (int i=array.length/2; i>=0; i--) {
            heapify(i);
        }
    }

    public Node max() {
        return this.data[0];
    }

    public Node removeMax() {
        Node max = this.max();
        swap(0, this.size-1);
        this.size = this.size - 1;
        heapify(0);
        return max;
    }

    public void increaseKey(int index, int key) {
        if (data[index].getKey() >= key) {
            return;
        }
        data[index].setKey(key);
        while ((index >= 0) && (data[parent(index)].getKey() < data[index].getKey())) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void insertKey(int key) {
        Node[] newData = new Node[this.size + 1];
        for (int i=0; i<this.size; i++) {
            newData[i] = this.data[i];
        }
        newData[this.size] = new Node(INT_MIN);
        this.size = this.size + 1;
        this.data = newData;
        increaseKey(this.size-1, key);
    }

    public static void sort(Node[] array) {
        MaxHeap heap = new MaxHeap(array);
        for (int i=array.length-1; i>0; i--) {
            array[i] = heap.removeMax();
        }
    }

    public void printAsArray() {
        for (int i=0; i< size; i++) {
            System.out.print(data[i].getKey());
            if (i != size) {
                System.out.print(" ");
            }
        }
    }

    public void printAsHeap() {

    }

    private void swap(int a, int b) {
        Node temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp;
    }
}
