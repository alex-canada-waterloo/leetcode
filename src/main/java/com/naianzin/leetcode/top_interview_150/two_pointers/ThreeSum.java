package com.naianzin.leetcode.top_interview_150.two_pointers;

import java.sql.Array;
import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        var treeSums = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int num1;
        int num2;
        int num3;
        int sum;
        int leftPointer;
        int rightPointer;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            num1 = nums[i];
            leftPointer = i + 1;
            rightPointer = nums.length - 1;
            while (leftPointer < rightPointer) {
                num2 = nums[leftPointer];
                num3 = nums[rightPointer];
                sum = num1 + num2 + num3;
                if (sum == 0) {
                    treeSums.add(List.of(num1, num2, num3));
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }
                    leftPointer++;
                    rightPointer--;
                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }
        return treeSums;
    }

    public static void main(String[] args) {
        var service = new ThreeSum();
        System.out.println(service.threeSum(new int[] {-1,0,1,2,-1,-4}) + " expected: [[-1,-1,2],[-1,0,1]]");
        System.out.println(service.threeSum(new int[] {0, 0, 0}) + " expected: [[0, 0, 0]]");
    }
}
