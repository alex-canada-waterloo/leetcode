package com.naianzin.leetcode.top_interview_150.bit_manipulation;

public class NumberOf1Bits {

    // https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
    public int hammingWeight(int n) {
        int numberOfSetBits = 0;
        for (int i = 0; i < 32; i++) {
            numberOfSetBits += (n >>> i) & 1;
        }
        return numberOfSetBits;
    }
}
