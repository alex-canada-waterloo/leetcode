package com.naianzin.leetcode.top_interview_150.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        var queue = new PriorityQueue<Integer>(k + 1);
        Arrays.stream(nums).forEach(num -> {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        });
        return queue.poll();
    }

    public static void main(String[] args) {
        var service = new KthLargestElementInArray();
        System.out.println(service.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4) + " Expected: 4");
    }
}
