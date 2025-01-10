package com.naianzin.leetcode.top_interview_150.math;

// https://leetcode.com/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        var service = new PlusOne();
        System.out.println(service.plusOne(new int[]{}) + " Expected");
    }
}
