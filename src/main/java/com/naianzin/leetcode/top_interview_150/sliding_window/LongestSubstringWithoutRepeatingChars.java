package com.naianzin.leetcode.top_interview_150.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    // Given a string s, find the length of the longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        var registry = new HashSet<Character>();
        var left = 0;
        var right = 0;
        char currChar;
        var maxLen = 0;
        while (right < s.length()) {
            currChar = s.charAt(right);
            if (registry.add(currChar)) {
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else {
                registry.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var service = new LongestSubstringWithoutRepeatingChars();
        System.out.println(service.lengthOfLongestSubstring("bbbbb") + " expected 1");
        System.out.println(service.lengthOfLongestSubstring("pwwkew") + " expected 3");
        System.out.println(service.lengthOfLongestSubstring("abcabcbb") + " expected 3");
        System.out.println(service.lengthOfLongestSubstring("aab") + " expected 2");
    }
}
