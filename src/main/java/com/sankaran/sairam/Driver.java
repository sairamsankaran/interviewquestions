package com.sankaran.sairam;

public class Driver {
    public static void main(String [] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addKey(1);
        linkedList.addKey(2);
        linkedList.addKey(3);
        linkedList.print(); System.out.println();

        linkedList.deleteKey(1);
        linkedList.print(); System.out.println();

        linkedList.deleteKey(2);
        linkedList.print(); System.out.println();

        linkedList.reverse();
        linkedList.print(); System.out.println();

        linkedList.deleteKey(3);
        linkedList.print(); System.out.println();

        // delete from empty list
        linkedList.deleteKey(3);
        linkedList.print(); System.out.println();

        // reverse empty list
        linkedList.reverse();
        linkedList.print(); System.out.println();

        linkedList.addKey(1);
        linkedList.addKey(2);
        linkedList.addKey(3);
        linkedList.print(); System.out.println();
        // reverse iteratively
        linkedList.reverse();
        linkedList.print(); System.out.println();
        //reverse recursively
        Node head = linkedList.getHead();
        head = LinkedList.reverse(head, null);
        linkedList.setHead(head);
        linkedList.print(); System.out.println();

        int[] array = {1, 2, 3, 4, 5};
        Node[] nodeArray = new Node[array.length];

        for (int i = 0; i < array.length; i++) {
            nodeArray[i] = new Node(array[i]);
        }

        MaxHeap heap = new MaxHeap(nodeArray);
        heap.printAsArray(); System.out.println();

        heap.increaseKey(2, 10);
        heap.printAsArray(); System.out.println();

        heap.insertKey(7);
        heap.printAsArray(); System.out.println();

        MaxHeap.sort(nodeArray);
        for (int i = 0; i < nodeArray.length; i++) {
            System.out.print(nodeArray[i].getKey() + " ");
        }
    }
}