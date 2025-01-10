package com.naianzin.leetcode.top_interview_150.two_pointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        var lowerS = s.toLowerCase();
        var left = 0;
        var right = lowerS.length() - 1;
        while (left < right) {
            if (lowerS.charAt(left) != lowerS.charAt(right)) {
                if (!Character.isLetterOrDigit(lowerS.charAt(left))) {
                    left++;
                    if (!Character.isLetterOrDigit(lowerS.charAt(right))) {
                        right--;
                        continue;
                    }
                    continue;
                }

                if (!Character.isLetterOrDigit(lowerS.charAt(right))) {
                    right--;
                    if (!Character.isLetterOrDigit(lowerS.charAt(left))) {
                        left++;
                        continue;
                    }
                    continue;
                }

                return false;
            } else {
                left++;
                right--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        var service = new ValidPalindrome();
        System.out.println(service.isPalindrome("A man, a plan, a canal: Panama") + " expected: true");
//        System.out.println(service.isPalindrome("race a car") + " expected: false");
//        System.out.println(service.isPalindrome(" ") + " expected: true");
//        System.out.println(service.isPalindrome("aa") + " expected: true");
    }
}
