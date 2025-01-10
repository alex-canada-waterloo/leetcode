package com.naianzin.leetcode.top_interview_150.array_string;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.out;
import static java.util.Arrays.sort;

public class HIndex {

    /*
    Given an array of integers citations where citations[i] is the number of citations a researcher received
    for their ith paper, return the researcher's h-index.

    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h
    such that the given researcher has published at least h papers that have each been cited at least h times.
     */
    public int hIndex(int[] citations) {
        var n = citations.length;
        var counts = new int[n + 1];
        for (var citation : citations) {
            if (citation >= n) {
                counts[n]++;
            } else {
                counts[citation]++;
            }
        }

        var total = 0;
        for (var i = n; i >= 0; i--) {
            total += counts[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var hIndex = new HIndex();

        out.println(hIndex.hIndex(new int[] {3,0,6,1,5}) + " expected 3");
        out.println(hIndex.hIndex(new int[] {1,3,1}) + " expected 1");
        out.println(hIndex.hIndex(new int[] {1,1}) + " expected 1");
    }
}
