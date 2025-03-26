package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        if (root.left != null) {
            var right = root.right;
            var left = root.left;

            root.right = root.left;
            root.left = null;

            if (left.right == null) {
                left.right = right;
            } else {
                var p = left.right;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = right;
            }
        }
        flatten(root.right);
    }





    public static void main(String[] args) {
        var tree = TreeNode.arrayToTree(new Integer[]{1,2,5,3,4,null,6});
        printTree(tree);

        var service = new FlattenBinaryTreeToLinkedList();
        service.flatten(tree);
        printTree(tree);
    }
}
