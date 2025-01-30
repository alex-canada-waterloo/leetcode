package com.naianzin.leetcode.top_interview_150.stack;

public class MinStack {

    private final int[] stack;
    private final int[] minStack;

    private int top = -1;
    private int minTop   = -1;

    public MinStack() {
        stack = new int[3_001];
        minStack = new int[3_001];
    }

    public void push(int val) {
        stack[++top] = val;
        if (minTop == -1 || val <= minStack[minTop]) {
            minStack[++minTop] = val;
        }
    }

    public void pop() {
        if (top == -1) {
            return;
        }
        if (stack[top--] == minStack[minTop]) {
            --minTop;
        }
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minTop];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2

        // Testcase provided in the prompt
        minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());    // Output: 2147483647
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 2147483646
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 2147483646
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());    // Output: 2147483647
        System.out.println(minStack.getMin()); // Output: 2147483647
        minStack.push(-2147483648);
        System.out.println(minStack.top());    // Output: -2147483648
        System.out.println(minStack.getMin()); // Output: -2147483648
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 2147483647
    }
}
