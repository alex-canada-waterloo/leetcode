package com.naianzin.leetcode.top_interview_150.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

    /*
    You are given a sorted unique integer array nums.
    A range [a,b] is the set of all integers from a to b (inclusive).
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
    That is, each element of nums is covered by exactly one of the ranges,
    and there is no integer x such that x is in one of the ranges but not in nums.
    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        var ranges = new ArrayList<String>();
        int startIndex = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[startIndex] != i - startIndex) {
                if (i - startIndex > 1) {
                    sb.append(nums[startIndex]).append("->").append(nums[i-1]);
                    ranges.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(nums[startIndex]);
                    ranges.add(sb.toString());
                    sb.setLength(0);
                }
                startIndex = i;
            }
        }
        if (startIndex < nums.length - 1) {
            sb.append(nums[startIndex]).append("->").append(nums[nums.length - 1]);
            ranges.add(sb.toString());
        } else {
            sb.append(nums[startIndex]);
            ranges.add(sb.toString());
        }
        return ranges;
    }

    public static void main(String[] args) {
        var detector = new SummaryRanges();
        System.out.println(detector.summaryRanges(new int[]{0,1,2,4,5,7}) + " Expected: '0->2', '4->5', '7'");
//        System.out.println(detector.summaryRanges(new int[]{0,2,3,4,6,8,9}) + " Expected: '0', '2->4', '6', '8->9'");
    }

}
