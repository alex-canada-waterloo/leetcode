package com.naianzin.leetcode.top_interview_150.binary_tree.bst;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ToSortedList {

    public List<Integer> toSortedList(TreeNode root) {
        var result = new ArrayList<Integer>();
        toSortedList(root, result);
        return result;
    }

    private void toSortedList(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            toSortedList(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            toSortedList(root.right, result);
        }
    }

    public static void main(String[] args) {
        var service = new ToSortedList();
        var root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(6, null, null));
        System.out.println(service.toSortedList(root) + " Expected: [1, 2, 3, 4, 6]");
    }
}
