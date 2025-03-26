package com.naianzin.leetcode.top_interview_150.binary_tree.bst;

import com.naianzin.leetcode.util.model.TreeNode;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return num * 10 + node.val;
        } else {
            var leftSum = 0;
            var rightSum = 0;
            if (node.left != null) {
                leftSum = helper(node.left, num * 10 + node.val);
            }
            if (node.right != null) {
                rightSum = helper(node.right, num * 10 + node.val);
            }
            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) {
        var tree = TreeNode.arrayToTree(new Integer[]{4,9,0,5,1,null,null});
        printTree(tree);

        var service = new SumRootToLeafNumbers();
        System.out.println(service.sumNumbers(tree) + " Expected: 1026");
    }

}
