package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class ConstructBinaryTreeFromInorderAndPostorder {

    private final Map<Integer, Integer> inorderMap = new HashMap<>();
    private int postOrderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postOrderIndex = postorder.length - 1;
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        var rootVal = postorder[postOrderIndex--];
        var inorderIndex = inorderMap.get(rootVal);
        var rightNode = helper(postorder, inorderIndex + 1, right);
        var leftNode = helper(postorder, left, inorderIndex - 1);
        return new TreeNode(rootVal, leftNode, rightNode);
    }


    public static void main(String[] args) {
        var service = new ConstructBinaryTreeFromInorderAndPostorder();

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        var tree = service.buildTree(inorder, postorder);
        printTree(tree);
    }
}
