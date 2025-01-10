package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class WorldPattern {

    public boolean wordPattern(String pattern, String s) {

        var patternToS = new HashMap<Character, String>();
        var sToPattern = new HashMap<String, Character>();

        var words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        for (var i = 0; i < pattern.length(); i++) {
            var ch = pattern.charAt(i);
            var world = words[i];

            var chToWorldMapping = patternToS.get(ch);
            var worldToChMapping = sToPattern.get(world);

            if (chToWorldMapping == null && worldToChMapping == null) {
                patternToS.put(ch, world);
                sToPattern.put(world, ch);
            } else if (! Objects.equals(ch, worldToChMapping) || !Objects.equals(world, chToWorldMapping)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var detector = new WorldPattern();

        System.out.println(detector.wordPattern("abba", "dog cat cat dog") + " Expected: true");
        System.out.println(detector.wordPattern("abba", "dog cat cat fish") + " Expected: false");
        System.out.println(detector.wordPattern("aaaa", "dog cat cat dog") + " Expected: false");
        System.out.println(detector.wordPattern("abba", "dog dog dog dog") + " Expected: false");
    }
}
