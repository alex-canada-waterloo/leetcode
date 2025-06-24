package com.naianzin.leetcode.top_interview_150.binary_search;

import java.util.Arrays;

public class FirstAndLastPositionInSortedArray {

    private static final int[] EMPTY_RESULT = new int[] {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return EMPTY_RESULT;
        }
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        var first = -1;
        int middle;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            if (nums[middle] == target) {
                first = middle;
            }
        }
        return first;
    }

    private int findLast(int[] nums, int target) {
        var last = -1;
        int middle;
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            if (nums[middle] == target) {
                last = middle;
            }
        }
        return last;
    }


    public static void main(String[] args) {
        var service = new FirstAndLastPositionInSortedArray();
        System.out.println(Arrays.toString(service.searchRange(new int[]{5,7,7,8,8,10}, 8)) + " Expected: [3, 4]");
        System.out.println(Arrays.toString(service.searchRange(new int[]{}, 8)) + " Expected: [-1, -1]");
        System.out.println(Arrays.toString(service.searchRange(new int[]{8}, 8)) + " Expected: [0, 0]");
        System.out.println(Arrays.toString(service.searchRange(new int[]{8, 8, 8, 8, 8}, 8)) + " Expected: [0, 4]");
    }
}
