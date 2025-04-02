package com.naianzin.leetcode.top_interview_150.binary_tree.bst;

import com.naianzin.leetcode.util.model.TreeNode;

import static com.naianzin.leetcode.util.model.TreeNode.arrayToTree;
import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class ValidateBST {

    private boolean isValid = true;
    private Integer prevElement;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }

    private void helper(TreeNode root) {
        if (root == null || !isValid) {
            return;
        }
        helper(root.left);
        if (isValid && prevElement != null) {
            isValid = root.val > prevElement;
        }
        prevElement = root.val;
        helper(root.right);
    }

    public static void main(String[] args) {
        var tree = arrayToTree(new Integer[] {5,1,4,null,null,3,6});
        printTree(tree);

        var service = new ValidateBST();
        System.out.println(service.isValidBST(tree) + " Expected: false");
    }
}
