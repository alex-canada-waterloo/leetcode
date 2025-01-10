package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode root, int level) {
        int leftLevel = level;
        int rightLevel = level;
        if (root.left != null) {
            leftLevel = maxDepth(root.left, level + 1);
        }
        if (root.right != null) {
            rightLevel = maxDepth(root.right, level + 1);
        }
        return Math.max(leftLevel, rightLevel);
    }
}
