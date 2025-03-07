package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class ConstructBinaryTreeFromPreorderAndInorder {

    private int preOrderIndex = 0;
    private final Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        var rootVal = preorder[preOrderIndex++];
        var inorderIndex = inorderMap.get(rootVal);
        return new TreeNode(rootVal,
                helper(preorder, left, inorderIndex - 1),
                helper(preorder, inorderIndex + 1, right));
    }

    public static void main(String[] args) {
        var service = new ConstructBinaryTreeFromPreorderAndInorder();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        var tree = service.buildTree(preorder, inorder);
        printTree(tree);
    }
}
