package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        var set = new HashSet<Integer>(nums.length, 1.0F);
        for (int num : nums) {
            set.add(num);
        }
        int longestSequence = 0;
        int currentSequence;
        int nextNumber;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            currentSequence = 1;
            nextNumber = num + 1;
            while (set.contains(nextNumber)) {
                currentSequence++;
                nextNumber++;
            }
            if (currentSequence > longestSequence) {
                longestSequence = currentSequence;
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        var service = new LongestConsecutiveSequence();

        System.out.println(service.longestConsecutive(new int[]{100,4,200,1,3,2}) + " Expected: 4");
    }
}