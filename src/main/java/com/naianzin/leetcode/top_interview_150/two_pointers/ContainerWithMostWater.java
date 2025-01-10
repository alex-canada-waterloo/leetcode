package com.naianzin.leetcode.top_interview_150.two_pointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        var leftPointer = 0;
        var rightPointer = height.length - 1;
        var maxVolume = 0;
        var leftHeight = 0;
        var rightHeight = 0;
        var currentVolume = 0;
        while (leftPointer < rightPointer) {
            leftHeight = height[leftPointer];
            if (leftHeight == 0) {
                leftPointer++;
                continue;
            }
            rightHeight = height[rightPointer];
            if (rightHeight == 0) {
                rightPointer--;
                continue;
            }
            currentVolume = Math.min(leftHeight, rightHeight) * (rightPointer - leftPointer);
            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
            }
            if (leftHeight <= rightHeight) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        var service = new ContainerWithMostWater();

        System.out.println(service.maxArea(new int[] {1,8,6,2,5,4,8,3,7}) + " Expected: 49");
    }
}
