package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
         if (left == null && right == null) {
             return true;
         }
         if (left == null || right == null || left.val != right.val) {
             return false;
         }
         return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
