package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class WordsDetector {

    public boolean canConstruct(String ransomNote, String magazine) {
        // magazine to map
        var frequencyMap = new HashMap<Character, Integer>();
        for (var i = 0; i < magazine.length(); i++) {
            var ch = magazine.charAt(i);
            var frequency = frequencyMap.get(ch);
            frequency = frequency == null ? 1 : ++frequency;
            frequencyMap.put(ch, frequency);
        }

        // Iterate through ransomNote and deduct occurrences from magazine frequencyMap
        for (var i = 0; i < ransomNote.length(); i++) {
            var ch = ransomNote.charAt(i);
            var frequency = frequencyMap.get(ch);
            if (frequency == null || frequency == 0) {
                return false;
            } else {
                frequencyMap.put(ch, --frequency);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var detector = new WordsDetector();

        System.out.println(detector.canConstruct("aa", "aab") + " Expected: true");
        System.out.println(detector.canConstruct("a", "b") + " Expected: false");
        System.out.println(detector.canConstruct("a", "a") + " Expected: true");
        System.out.println(detector.canConstruct("a", "b") + " Expected: false");
        System.out.println(detector.canConstruct("aa", "ab") + " Expected: false");
    }
}
