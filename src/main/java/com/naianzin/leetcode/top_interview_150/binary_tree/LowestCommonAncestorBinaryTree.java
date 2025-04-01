package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // reached bottom
        if (root == null || root == p || root == q) {
            return root;
        }

        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        var tree = TreeNode.arrayToTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        printTree(tree);

        var service = new LowestCommonAncestorBinaryTree();
        if (tree != null) {
            var lowestCommonAncestor = service.lowestCommonAncestor(tree, tree.left, tree.right);
            System.out.println(lowestCommonAncestor.val);
        }
    }
}
