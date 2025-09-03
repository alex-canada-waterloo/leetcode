package com.naianzin.leetcode.top_interview_150.heap;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var result = new ArrayList<List<Integer>>(k);
        var p1 = 0;
        var p2 = 0;
        while (k > 0) {
            var probe1 = nums1[p1] + nums2[p2 + 1];
            var probe2 = nums1[p1 + 1] + nums2[p2];
            if (probe1 < probe2) {
                p2++;
            } else {
                p1++;
            }
            result.add(List.of(nums1[p1], nums2[p2]));
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        var service = new FindKPairsWithSmallestSums();
        var result = service.kSmallestPairs(
                new int[] {1, 7, 11},
                new int[] {2, 4, 6},
                3);
        System.out.println(result + " Expected: [1,2],[1,4],[1,6]");
    }
}
