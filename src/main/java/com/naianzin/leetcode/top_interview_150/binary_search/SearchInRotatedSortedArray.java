package com.naianzin.leetcode.top_interview_150.binary_search;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        var pivotIndex = findPivotIndex(nums);
        return binarySearchWithPivot(nums, pivotIndex, target);
    }

    private int findPivotIndex(int[] nums) {
        var pivot = 0;
        var prev = nums[0];
        for (var i = 1; i < nums.length; i++) {
            if (prev > nums[i]) {
                pivot = i;
                break;
            }
            prev = nums[i];
        }
        return pivot;
    }

    private int binarySearchWithPivot(int[] nums, int pivotIndex, int target) {
        var left = 0;
        var right = nums.length - 1;
        int middle;
        int pivotedMiddle;
        while (left <= right) {
            middle = (left + right) / 2;
            pivotedMiddle = (middle + pivotIndex) % nums.length;
            if (nums[pivotedMiddle] == target) {
                return pivotedMiddle;
            } else if (nums[pivotedMiddle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var service = new SearchInRotatedSortedArray();
        var nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        for (var i = 0; i < 9; i++) {
            System.out.println(i + "  " + service.search(nums, i));
        }
    }
}


