package com.naianzin.leetcode.top_interview_150.divide_and_conquer;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.Arrays;

import static com.naianzin.leetcode.util.print.PrintTree.printTreeAsc;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedSubarrayToBstNode(nums, 0, nums.length - 1);
    }

    private TreeNode sortedSubarrayToBstNode(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }
        if (beginIndex == endIndex) {
            return new TreeNode(nums[beginIndex], null, null);
        }
        var middle = (beginIndex + endIndex) /  2;
        var leftNode = sortedSubarrayToBstNode(nums, beginIndex, middle - 1);
        var rightNode = sortedSubarrayToBstNode(nums, middle + 1, endIndex);
        return new TreeNode(nums[middle], leftNode, rightNode);
    }

    public static void main(String[] args) {
        var service = new SortedArrayToBST();

        var tree = service.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        printTreeAsc(tree);
        System.out.println(" Expected: 0,-10,5,null,-3,null,9");
    }
}
