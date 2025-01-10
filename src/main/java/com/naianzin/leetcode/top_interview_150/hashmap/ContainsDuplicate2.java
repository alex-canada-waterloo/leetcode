package com.naianzin.leetcode.top_interview_150.hashmap;

import java.util.HashMap;

public class ContainsDuplicate2 {

    /*
    https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var numIndexMap = new HashMap<Integer, Integer>();

        // iterate the array, store elements in the map, and lookup for duplicates checking abs(i-j) <= k
        for (var i = 0; i < nums.length; i++) {
            var currentNumber = nums[i];

            if (numIndexMap.containsKey(currentNumber)) {
                var j = numIndexMap.get(currentNumber);
                if (Math.abs(i - j) <= k) {
                    return true;
                } else {
                    numIndexMap.put(currentNumber, i);
                }
            } else {
                numIndexMap.put(currentNumber, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var detector = new ContainsDuplicate2();
        System.out.println(detector.containsNearbyDuplicate(new int[]{1,2,3,1}, 3) + " Expected: true");
        System.out.println(detector.containsNearbyDuplicate(new int[]{1,0,1,1}, 1) + " Expected: true");
        System.out.println(detector.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2) + " Expected: false");
    }

}
