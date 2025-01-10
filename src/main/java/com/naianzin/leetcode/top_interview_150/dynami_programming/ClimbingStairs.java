package com.naianzin.leetcode.top_interview_150.dynami_programming;

// https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int counter1 = 0;
        int counter2 = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = counter2;
            counter2 += counter1;
            counter1 = temp;
        }
        return counter1 + counter2;
    }

    public static void main(String[] args) {
        var service = new ClimbingStairs();

        System.out.println(service.climbStairs(0) + " Expected: 0");
        System.out.println(service.climbStairs(1) + " Expected: 1");
        System.out.println(service.climbStairs(2) + " Expected: 2");
        System.out.println(service.climbStairs(3) + " Expected: 3");
        System.out.println(service.climbStairs(4) + " Expected: 5");
        System.out.println(service.climbStairs(5) + " Expected: 8");
        System.out.println(service.climbStairs(6) + " Expected: 13");
    }
}
