package com.naianzin.leetcode.top_interview_150.binary_search;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int middle = -1;
        var left = 0;
        var right = nums.length;
        while (left < right - 1) {
            middle = (left + right) / 2;
            if (nums[left] < nums[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return nums[right];
    }

    public static void main(String... args) {
        var service = new FindMinimumInRotatedSortedArray();
        System.out.println(service.findMin(new int[] {4,5,1,2,3}) + " Expected: 1");
    }
}
