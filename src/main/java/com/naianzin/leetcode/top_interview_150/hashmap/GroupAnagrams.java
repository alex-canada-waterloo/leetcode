package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var anagramGroups = new HashMap<String, List<String>>();
        char[] charArray;
        String sortedWord;
        for (var word: strs) {
            charArray = word.toCharArray();
            Arrays.sort(charArray);
            sortedWord = new String(charArray);
            anagramGroups
                    .computeIfAbsent(sortedWord, _ -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        var service = new GroupAnagrams();

        var anagramGroups1 = service.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
        System.out.println(anagramGroups1.get(0));
        System.out.println(anagramGroups1.get(1));
        System.out.println(anagramGroups1.get(2));
        System.out.println("Expected:");
        System.out.println("eat, tea, ate");
        System.out.println("bat");
        System.out.println("tan, nat");
    }
}
