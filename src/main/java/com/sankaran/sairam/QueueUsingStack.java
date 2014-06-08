package com.sankaran.sairam;

public class QueueUsingStack {
    Stack incoming = new Stack();
    Stack outgoing = new Stack();

    public boolean isEmpty() {
        return (outgoing.isEmpty() && incoming.isEmpty());
    }

    public void enqueue(int i) {
        incoming.push(i);
    }

    public int dequeue() {
        if (!outgoing.isEmpty()) {
            return outgoing.pop();
        }
        while (!incoming.isEmpty()) {
            outgoing.push(incoming.pop());
        }
        return outgoing.pop();
    }

}
