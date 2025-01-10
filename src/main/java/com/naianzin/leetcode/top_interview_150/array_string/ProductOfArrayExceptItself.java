package com.naianzin.leetcode.top_interview_150.array_string;

import java.util.Arrays;

import static java.lang.System.out;

// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {

        var result = new int[nums.length];

        // calculate prefix
        int prefix = 1;
        result[0] = prefix;
        int lastIndex = nums.length - 1;
        for (var i = 0; i < lastIndex; i++) {
            prefix *= nums[i];
            result[i + 1] = prefix;
        }

        // calculate suffixes
        int suffix = 1;
        for (int i = lastIndex; i > 0; i--) {
            suffix *= nums[i];
            result[i - 1] *= suffix;
        }

        return result;
    }

    public static void main(String[] args) {
        var s = new ProductOfArrayExceptItself();
        out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})) + " expected: \n[24, 12, 8, 6]");
        out.println(Arrays.toString(s.productExceptSelf(new int[]{-1, 1, 0, -3, 3})) + " expected: \n[0, 0, 9, 0, 0]");
        out.println(Arrays.toString(s.productExceptSelf(new int[]{2, 3})) + " expected: \n[3, 2]");
    }
}
