package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


// https://leetcode.com/problems/binary-search-tree-iterator/description/?envType=study-plan-v2&envId=top-interview-150
public class BSTIterator {

    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        pushLeft(root);
    }

    public int next() {
        var node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
