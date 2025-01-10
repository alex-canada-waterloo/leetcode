package com.naianzin.leetcode.top_interview_150.bit_manipulation;

public class SingleNumber2 {

    // https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= nums[i];
        }
        return result >> 1;
    }

    public static void main(String[] args) {
        var service = new SingleNumber2();
        System.out.println(service.singleNumber(new int[] {2,2,3,2}) + " Expected: 3");
    }
}
