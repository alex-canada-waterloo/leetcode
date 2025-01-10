package com.naianzin.leetcode.top_interview_150.two_pointers;

import java.util.*;

import static java.util.Objects.isNull;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        int diff;
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }
            map.put(target - num, i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        var service = new TwoSum();

        System.out.println(Arrays.toString(service.twoSum(new int[] {2,7,11,15}, 9)) + " expected: [0,1]");
        System.out.println(Arrays.toString(service.twoSum(new int[] {3,2,4}, 6)) + " expected: [1,2]");
        System.out.println(Arrays.toString(service.twoSum(new int[] {3,3}, 6)) + " expected: [0,1]");

    }
}
