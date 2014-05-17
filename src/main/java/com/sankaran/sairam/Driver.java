package com.sankaran.sairam;

public class Driver {
    public static void main(String [] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addValue("1");
        linkedList.addValue("2");
        linkedList.addValue("3");
        linkedList.print(); System.out.println();
        linkedList.deleteValue("1");
        linkedList.print(); System.out.println();
        linkedList.deleteValue("2");
        linkedList.print(); System.out.println();

        linkedList.reverse();
        linkedList.print(); System.out.println();

        linkedList.deleteValue("3");
        linkedList.print(); System.out.println();

        linkedList.deleteValue("3");
        linkedList.print(); System.out.println();

        linkedList.reverse();
        linkedList.print(); System.out.println();

        linkedList.addValue("1");
        linkedList.addValue("2");
        linkedList.addValue("3");
        linkedList.print(); System.out.println();
        linkedList.reverse();
        linkedList.print(); System.out.println();
    }
}
