package com.naianzin.leetcode.top_interview_150.binary_tree.bst;

import com.naianzin.leetcode.util.model.TreeNode;

public class MinimumAbsoluteDifference {

    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevNode.val));
        }
        prevNode = node;

        inOrderTraversal(node.right);
    }


    public static void main(String[] args) {
        var root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(6, null, null));
        var service = new MinimumAbsoluteDifference();
        System.out.println(service.getMinimumDifference(root) + " Expected: 1");

        root = new TreeNode(236,
                new TreeNode(104, null, new TreeNode(227, null, null)),
                new TreeNode(701, null, new TreeNode(911, null, null)));
        System.out.println(service.getMinimumDifference(root) + " Expected: 9");
    }
}
