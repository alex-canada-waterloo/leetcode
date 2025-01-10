package com.naianzin.leetcode.top_interview_150.array_string;

// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {

    public boolean canJump(int[] nums) {

        var stepsLeft = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            if (stepsLeft < num) {
                stepsLeft = num;
            }
            --stepsLeft;
            if (stepsLeft < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        var jumpGame = new JumpGame();

        var nums1 = new int[] {2, 3, 1, 1, 4};
        var canJump1 = jumpGame.canJump(nums1);
        System.out.println(canJump1);

        var nums2 = new int[] {3, 2, 1, 0, 4};
        var canJump2 = jumpGame.canJump(nums2);
        System.out.println(canJump2);

        var nums3 = new int[] {0};
        var canJump3 = jumpGame.canJump(nums3);
        System.out.println(canJump3);
    }
}
