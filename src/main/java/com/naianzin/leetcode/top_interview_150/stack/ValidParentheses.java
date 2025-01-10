package com.naianzin.leetcode.top_interview_150.stack;

import java.util.LinkedList;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        var stack = new LinkedList<Character>();
        char ch;
        for (var i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                var openingCh = stack.pop();
                if (!matches(openingCh, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char ch) {
        return switch (ch) {
            case '(', '[', '{' -> true;
            default -> false;
        };
    }

    private boolean matches(char openCh, char closingCh) {
        return switch (openCh) {
            case '(' -> ')' == closingCh;
            case '[' -> ']' == closingCh;
            case '{' -> '}' == closingCh;
            default -> false;
        };
    }

    public static void main(String[] args) {
        var detector = new ValidParentheses();

        System.out.println(detector.isValid("((") + " Expected: false");
        System.out.println(detector.isValid("[()]") + " Expected: true");
    }
}
