package com.naianzin.leetcode.top_interview_150.array_string;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (k >= nums.length) {
            k = k % nums.length;
        }

        if (nums.length < 2 || k < 1) {
            return;
        }

        var hops = 0;
        var pos = 0;
        var startingIndex = 0;
        var tmp1 = nums[0];
        var tmp2 = 0;
        do {

            pos += k;
            if (pos >= nums.length) {
                pos -= nums.length;
            }

            tmp2 = nums[pos];
            nums[pos] = tmp1;
            tmp1 = tmp2;

            if (pos == startingIndex) {
                ++pos;
                tmp1 = nums[pos];
                startingIndex = pos;
            }

        } while (++hops < nums.length);
    }


    public static void main(String[] args) {
        var rotateArray = new RotateArray();
        var nums1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        var nums2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8};
        rotateArray.rotate(nums2, 4);
        System.out.println(Arrays.toString(nums2));

        var nums3 = new int[] { 1, 2};
        rotateArray.rotate(nums3, 0);
        System.out.println(Arrays.toString(nums3));

        var nums4 = new int[] { 1, 2};
        rotateArray.rotate(nums4, 2);
        System.out.println(Arrays.toString(nums4));
    }
}
