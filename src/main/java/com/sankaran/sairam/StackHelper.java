package com.sankaran.sairam;

public class StackHelper {
    public static Stack sort(Stack stack) {
        Stack sorted = new Stack();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
    }
}
