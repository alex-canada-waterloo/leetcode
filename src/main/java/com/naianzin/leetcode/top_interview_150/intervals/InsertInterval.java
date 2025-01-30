package com.naianzin.leetcode.top_interview_150.intervals;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        var mergedIntervals = new ArrayList<int[]>(intervals.length + 1);
        boolean pushed = false; // new interval pushed

        for (var interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // left interval no overlap
                mergedIntervals.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // right interval no overlap
                if (!pushed) {
                    mergedIntervals.add(newInterval);
                    pushed = true;
                }
                mergedIntervals.add(interval);
            } else {
                // overlapping interval -> merge
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!pushed) {
            mergedIntervals.add(newInterval);
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }

    public static void main(String[] args) {
        var service = new InsertInterval();

//        System.out.println(Arrays.deepToString(service.insert(new int[][] {
//                {1, 3},
//                {6, 9}},
//                new int[]{2, 5})) + " Expected: [[1, 5], [6, 9]");

        System.out.println(Arrays.deepToString(service.insert(new int[][] {
                {1, 5}},
                new int[]{2, 3})) + " Expected: [[1, 5]");
    }
}
