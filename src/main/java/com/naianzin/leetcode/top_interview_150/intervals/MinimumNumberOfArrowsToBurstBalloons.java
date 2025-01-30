package com.naianzin.leetcode.top_interview_150.intervals;

import java.util.Arrays;

import static java.util.Comparator.comparingInt;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, comparingInt(a -> a[0]));
        int arrows = 1;
        var areaEnd = points[0][1];
        for (int[] point : points) {
            if (point[0] > areaEnd) {
                arrows++;
                areaEnd = point[1];
            } else {
                areaEnd = Math.min(areaEnd, point[1]);
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        var service = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(service.findMinArrowShots(new int[][] {
                             {10,       16},
                   {2,      8},
                {1,   6},
                        {7,     12}
        }) + " Expected: 2");
    }
}
