package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        var seenNumbers = new HashSet<Integer>();
        int reminder;
        int temp;
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            temp = n;
            n = 0;
            do {
                reminder = temp % 10;
                temp /= 10;
                n += (int) Math.pow(reminder, 2);
            } while (temp != 0);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        var happyNumberDetector = new HappyNumber();

        System.out.println(happyNumberDetector.isHappy(19) + " Expected: true");
        System.out.println(happyNumberDetector.isHappy(2) + " Expected: false");
        System.out.println(happyNumberDetector.isHappy(7) + " Expected: true");
    }
}
