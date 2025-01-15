package com.naianzin.leetcode.top_interview_150.intervals;


import java.util.*;

// https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        var result = new ArrayList<int[]>(intervals.length);
        var currentInterval = intervals[0];
        result.add(currentInterval);

        for (var interval : intervals) {
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        var service = new MergeIntervals();

        System.out.println(Arrays.deepToString(service.merge(new int[][] {
                {1,                 10},
                { 2, 3},
                {      4, 5},
                {         6, 7},
                {              8, 9}
        })) + " Expected: [[1, 10]]");
    }
}
