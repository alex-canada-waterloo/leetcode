package com.naianzin.leetcode.top_interview_150.sliding_window;

public class MinimusSizeSubarraySum {


    /*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
    whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */
    public int minSubArrayLen(int target, int[] nums) {
        var len = nums.length;
        var left = 0;
        var windowSum = 0;
        var minLen = Integer.MAX_VALUE;
        for (var right = 0; right < len; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                // move left border ->
                minLen = Math.min(minLen, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        var service = new MinimusSizeSubarraySum();

        System.out.println(service.minSubArrayLen(7, new int[] {2,3,1,2,4,3}) + " expected: 2");
    }





    /*



     */
}
