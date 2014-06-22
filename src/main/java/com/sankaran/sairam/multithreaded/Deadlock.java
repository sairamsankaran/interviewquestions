package com.sankaran.sairam.multithreaded;

/*
Wait/Die and Wound/Wait can be used to avoid deadlock
Wait/Die
O needs resource locked by Y - O waits
Y needs resource locked by O - Y dies

Wound/Wait
O needs resource locked by Y - Y dies
Y needs resource locked by O - Y waits
 */

public class Deadlock {
    public static void main(String[] args) {
        Resource resource1 = new Resource(1234);
        Resource resource2 = new Resource(5678);

        Thread foo = new Thread(new Foo(resource1, resource2));
        Thread bar = new Thread(new Bar(resource1, resource2));
        foo.start();
        bar.start();
    }
}
