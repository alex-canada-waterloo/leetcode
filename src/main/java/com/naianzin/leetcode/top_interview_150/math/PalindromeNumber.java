package com.naianzin.leetcode.top_interview_150.math;

public class PalindromeNumber {

    // https://leetcode.com/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150
    public boolean isPalindrome(int x) {
        if ( x < 0) {
            return false;
        }
        int reversed = 0;
        int xCopy = x;
        while (x != 0) {
            int r = x % 10;
            x /= 10;
            reversed = reversed * 10 + r;
        }
        return reversed == xCopy;
    }


    public static void main(String[] args) {
        var service = new PalindromeNumber();
        System.out.println(service.isPalindrome(-121) + " Expected: false");
        System.out.println(service.isPalindrome(12321) + " Expected: true");
        System.out.println(service.isPalindrome(1) + " Expected: true");
        System.out.println(service.isPalindrome(121) + " Expected: true");
        System.out.println(service.isPalindrome(1211) + " Expected: false");
    }
}
