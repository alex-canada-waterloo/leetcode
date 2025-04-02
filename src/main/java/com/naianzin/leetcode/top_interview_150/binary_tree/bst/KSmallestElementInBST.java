package com.naianzin.leetcode.top_interview_150.binary_tree.bst;

import com.naianzin.leetcode.util.model.TreeNode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
public class KSmallestElementInBST {

    private int count = 0;
    private int result = -1;
    private int k;
    private boolean stop = false;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null || stop) {
            return;
        }
        inOrderTraversal(root.left);
        this.count++;
        if (count == k) {
            result = root.val;
            this.stop = true;
            return;
        }
        inOrderTraversal(root.right);
    }
}
