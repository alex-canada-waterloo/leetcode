package com.naianzin.leetcode.top_interview_150.binary_search;

// https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        var left = 1;
        var right = nums.length - 2;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return middle;
            }
            if (nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            } else if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        var service = new FindPeakElement();
        System.out.println(service.findPeakElement(new int[] {3,4,3,2,1}) + " Expected: 1");
    }
}
