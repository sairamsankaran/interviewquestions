package com.sankaran.sairam;

import java.util.ArrayList;

public class SetofStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();

    public SetofStacks() {
        Stack stack = new Stack();
        stacks.add(stack);
    }

    public boolean push(int i) {
        int numberOfStacks = stacks.size();
        if (stacks.get(numberOfStacks-1).push(i)) {
            return true;
        } else {
            Stack stack = new Stack();
            stack.push(i);
            stacks.add(stack);
            return true;
        }
    }

    public int pop() {
        int numberOfStacks = stacks.size();
        int top = stacks.get(numberOfStacks-1).pop();
        if (stacks.get(numberOfStacks-1).isEmpty()) {
            stacks.remove(numberOfStacks-1);
        }
        return top;
    }

    public int peek() {
        int numberOfStacks = stacks.size();
        int top = stacks.get(numberOfStacks-1).peek();
        return top;
    }
}
