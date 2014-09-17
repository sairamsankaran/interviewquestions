package com.sankaran.sairam;

import com.sankaran.sairam.interviewcake.Stack;

public class Driver {
    public static void main(String [] args) {

        System.out.println("2 + 2 = " +2+2);
        System.out.println("Linked List:");
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

        // deleteOldestNode from empty list
        linkedList.deleteKey(3);
        linkedList.print(); System.out.println();

        // reverse empty list
        linkedList.reverse();
        linkedList.print(); System.out.println();

        linkedList.insertKey(1);
        linkedList.insertKey(2);
        linkedList.insertKey(3);
        linkedList.insertKey(3);
        linkedList.print(); System.out.println();
        //remove duplicates
        Node newHead = LinkedList.removeDuplicates(linkedList.getHead());
        linkedList.setHead(newHead);
        linkedList.print(); System.out.println();
        // reverse iteratively
        linkedList.reverse();
        linkedList.print(); System.out.println();
        //reverse recursively
        Node head = linkedList.getHead();
        head = LinkedList.reverse(head, null);
        linkedList.setHead(head);
        linkedList.print(); System.out.println();



        System.out.println("Max Heap:");
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
        System.out.println("Stack:");
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

        System.out.println();
        System.out.println("Queue:");
        Node node = new Node(1);
        Queue queue = new Queue();
        queue.print(); System.out.println();
        //System.out.println(queue.dequeue());
        queue.enqueue(node);
        queue.print(); System.out.println();
        node = new Node(2);
        queue.enqueue(node);
        queue.print(); System.out.println();
        node = new Node(3);
        queue.enqueue(node);
        queue.print(); System.out.println();
        System.out.println(queue.dequeue().getKey());
        queue.print(); System.out.println();

        System.out.println();
        System.out.println("BST:");
        BST bst = new BST();
        bst.inOderTraversal(null); System.out.println();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeRoot = treeNode4;
        bst.insertNode(treeNode4);
        bst.preOderTraversal(treeRoot); System.out.println();
        bst.inOderTraversal(treeRoot); System.out.println();
        bst.postOderTraversal(treeRoot); System.out.println();

        TreeNode treeNode2 = new TreeNode(2);
        bst.insertNode(treeNode2);
        bst.preOderTraversal(treeRoot); System.out.println();
        bst.inOderTraversal(treeRoot); System.out.println();
        bst.postOderTraversal(treeRoot); System.out.println();

        TreeNode treeNode5 = new TreeNode(5);
        bst.insertNode(treeNode5);
        bst.preOderTraversal(treeRoot); System.out.println();
        bst.inOderTraversal(treeRoot); System.out.println();
        bst.postOderTraversal(treeRoot); System.out.println();

        TreeNode treeNode3 = new TreeNode(3);
        bst.insertNode(treeNode3);
        bst.preOderTraversal(treeRoot); System.out.println();
        bst.inOderTraversal(treeRoot); System.out.println();
        bst.postOderTraversal(treeRoot); System.out.println();

        System.out.println("Tree minimum: " + bst.getMin().getKey());
        System.out.println("Tree maximum: " + bst.getMax().getKey());

        if (bst.search(1) != null && bst.search(1).getKey() == 1) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        System.out.println("Successor of " + treeNode2.getKey() + " is: " + bst.successor(treeNode2).getKey());

        bst.deleteNode(treeNode4);
        System.out.println("Preorder");
        bst.preOderTraversal(treeRoot); System.out.println();
        System.out.println("Inorder");
        bst.inOderTraversal(treeRoot); System.out.println();
        System.out.println("Postorder");
        bst.postOderTraversal(treeRoot); System.out.println();

        bst.deleteNode(treeNode2);
        System.out.println("Preorder");
        bst.preOderTraversal(treeRoot); System.out.println();
        System.out.println("Inorder");
        bst.inOderTraversal(treeRoot); System.out.println();
        System.out.println("Postorder");
        bst.postOderTraversal(treeRoot); System.out.println();

        System.out.println();
        System.out.println("Dictionary:");
        Dictionary dictionary = new Trie();
        dictionary.addWord("cat");
        dictionary.addWord("car");
        dictionary.addWord("dog");
        System.out.println("Dictionary contains cat: " + dictionary.contains("cat"));
        System.out.println("Dictionary contains can: " + dictionary.contains("can"));
        System.out.println("Dictionary contains cel: " + dictionary.contains("cel"));

        System.out.println();
        System.out.println("Quick Sort String:");
        StringBuilder string = new StringBuilder("sairam".toLowerCase());
        System.out.println("Sorted string of " + string.toString() + " is: " + QuickSort.sortString(string, 0, string.toString().length()-1));

        System.out.println();
        System.out.println("String Manipulations:");
        Boolean result = StringMethods.isStringWithUniqueCharacters("iijkl");
        System.out.println("result = " + result);
        char[] name = {'s', 'a', 'i', 'r', 'a', 'm'};
        StringMethods.removeDuplicates(name);
        for (char c:name) {
            System.out.print(c);
        }
        System.out.print('\n');
        char[] fullName = {'s', 'a', 'i', 'r', 'a', 'm', ' ', 's', 'a', 'n', 'k', 'a', 'r', 'a', 'n'};
        StringMethods.encode(fullName);
        for (char c:StringMethods.encode(fullName)) {
            System.out.print(c);
        }

        System.out.println("Remove spaces ...");
        char[] input = {' ', ' ', ' ', 's','a', 'i', ' ', ' ', ' ', 'r','a','m', ' ', ' ', ' ', };
        Utility.removeSpaces(input, input.length);
        System.out.println();
    }
}