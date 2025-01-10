package com.naianzin.leetcode.top_interview_150.math;

// https://leetcode.com/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150
public class SqrtX {

    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        if (x <= 2) {
            return 1;
        }
        int left = 1;
        int right = x;
        int probe = 0;
        while (left <= right) {
            probe = (int) (((long) left + right) / 2);
            if ((long) probe * probe > x) {
                // but if
                if ((long) (probe - 1) * (probe - 1) < x) {
                    return probe - 1;
                }
                right = probe;
            } else if ( (long) probe * probe < x) {
                left = probe;
            } else {
                return probe;
            }
        }
        return probe;
    }

    public static void main(String[] args) {
        var service = new SqrtX();

        System.out.println(service.mySqrt(2147483647) + " Expected: 46340");
        System.out.println(service.mySqrt(2) + " Expected: 1");
        System.out.println(service.mySqrt(3) + " Expected: 1");
        System.out.println(service.mySqrt(4) + " Expected: 2");
        System.out.println(service.mySqrt(10) + " Expected: 3");
        System.out.println(service.mySqrt(100) + " Expected: 10");
    }

}
