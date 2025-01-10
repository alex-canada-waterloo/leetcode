package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        var s2t = new HashMap<Character, Character>();
        var t2s = new HashMap<Character, Character>();

        for (var i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);

            var s2tMapping = s2t.get(sChar);
            var t2sMapping = t2s.get(tChar);

            if (s2tMapping == null && t2sMapping == null) {
                s2t.put(sChar, tChar);
                t2s.put(tChar, sChar);
            } else if (s2tMapping == null || t2sMapping == null) {
                return false;
            } else if (s2tMapping != tChar || t2sMapping != sChar) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        var detector = new IsomorphicStrings();

        System.out.println(detector.isIsomorphic("badc", "baba") + " Expected: false");
    }
}
