package com.naianzin.leetcode.top_interview_150.binary_search;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var service = new SearchInsertPosition();

        System.out.println(service.searchInsert(new int[]{1,3,5,6}, 5) + " Expected: 2");
        System.out.println(service.searchInsert(new int[]{1,3,5,6}, 2) + " Expected: 1");
        System.out.println(service.searchInsert(new int[]{1,3,5,6}, 7) + " Expected: 4");
        System.out.println(service.searchInsert(new int[]{1,3}, 0) + " Expected: 0");
        System.out.println(service.searchInsert(new int[]{1,3}, 2) + " Expected: 1");
    }
}
