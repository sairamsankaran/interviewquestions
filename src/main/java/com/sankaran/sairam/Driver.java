package com.sankaran.sairam;

public class Driver {
    public static void main(String [] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertKey(1);
        linkedList.insertKey(2);
        linkedList.insertKey(3);
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

        linkedList.insertKey(1);
        linkedList.insertKey(2);
        linkedList.insertKey(3);
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

        System.out.println();

        Stack stack = new Stack();
        stack.print(); System.out.println();
        //stack.pop(); // throws exception
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print(); System.out.println();
        System.out.println(stack.peek() + "\n");
        stack.pop();
        stack.print(); System.out.println();
    }
}