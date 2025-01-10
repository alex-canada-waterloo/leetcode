package com.naianzin.leetcode.top_interview_150.bit_manipulation;

public class SingleNumber {

    // https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
