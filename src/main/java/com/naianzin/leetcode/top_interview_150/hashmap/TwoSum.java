package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var pairsMap = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var pairIndex = pairsMap.get(nums[i]);
            if (pairIndex != null && pairIndex != i) {
                return new int[] {i, pairIndex};
            } else {
                pairsMap.put(target - nums[i], i);
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        var twoSumDetector = new TwoSum();

        System.out.println(Arrays.toString(twoSumDetector.twoSum(new int[]{2, 7, 11, 15}, 9)) + " Expected: [0, 1]");

    }
}
