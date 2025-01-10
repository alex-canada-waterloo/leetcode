package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sMap = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            sMap.compute(sChar, (k, v) -> v != null ? ++v : 1);
        }

        for (var i = 0; i < t.length(); i++) {
            var tChar = t.charAt(i);
            var sCount = sMap.get(tChar);
            if (sCount == null || sCount == 0) {
                return false;
            } else {
                --sCount;
                sMap.put(tChar, sCount);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is Anagram: " + validAnagram.isAnagram(s, t));
    }
}
