package com.naianzin.leetcode.top_interview_150.stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        var stack = new int[10_000];
        var pointer = -1;
        var prevPointer = -1;
        for (var token : tokens) {
            switch (token) {
                case "+" -> {
                    prevPointer = pointer - 1;
                    stack[prevPointer] = stack[prevPointer] + stack[pointer];
                    pointer = prevPointer;
                }
                case "-" -> {
                    prevPointer = pointer - 1;
                    stack[prevPointer] = stack[prevPointer] - stack[pointer];
                    pointer = prevPointer;
                }
                case "*" -> {
                    prevPointer = pointer - 1;
                    stack[prevPointer] = stack[prevPointer] * stack[pointer];
                    pointer = prevPointer;
                }
                case "/" -> {
                    prevPointer = pointer - 1;
                    stack[prevPointer] =  stack[prevPointer] / stack[pointer];
                    pointer = prevPointer;
                }
                default -> stack[++pointer] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }

    public static void main(String[] args) {
        var service = new EvaluateReversePolishNotation();

        System.out.println(service.evalRPN(new String[] {
                "2","1","+","3","*"}) + " Expected: 9");

        System.out.println(service.evalRPN(new String[] {
                "4","13","5","/","+"}) + " Expected: 6");

        System.out.println(service.evalRPN(new String[] {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"}) + " Expected: 22");
    }
}
