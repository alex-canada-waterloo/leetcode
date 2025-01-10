package com.naianzin.leetcode.top_interview_150.array_string;

public class TrappingRainWater {

    public int trap(int[] height) {

        if (height.length < 3) {
            return 0;
        }

        int waterTotal = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int leftMax = height[leftPointer];
        int rightMax = height[rightPointer];

        while (leftPointer < rightPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                leftMax = Math.max(leftMax, height[leftPointer]);
                waterTotal += leftMax - height[leftPointer];
                leftPointer++;
            } else {
                rightMax = Math.max(rightMax, height[rightPointer]);
                waterTotal += rightMax - height[rightPointer];
                rightPointer--;
            }
        }

        return waterTotal;
    }

    public static void main(String[] args) {
        var solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[] {0,5,6,4,6,1,0,0,2,7}) + " expected 23");
    }
}
