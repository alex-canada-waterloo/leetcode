package com.naianzin.leetcode.top_interview_150.array_string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        char ch;
        boolean isLetter;
        int count = 0;
        boolean lastWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            ch = s.charAt(i);
            isLetter = Character.isLetter(ch);
            if (lastWord) {
                if (isLetter) {
                    count++;
                } else {
                    break;
                }
            } else {
                if (isLetter) {
                    count++;
                    lastWord = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var service = new LengthOfLastWord();
        System.out.println(service.lengthOfLastWord("Hello World") + " Expected: 5");
    }
}
