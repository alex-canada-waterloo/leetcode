package com.naianzin.leetcode.top_interview_150.binary_tree;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class BinaryTreeTraversalModes {

    public static void main(String[] args) {
        var arrayTree = new Integer[] {
                       1,
                  2,        3,
                4, 5,   null, 6};
        var tree = TreeNode.arrayToTree(arrayTree);
        printTree(tree);

        System.out.println("\n\nIn-Order traversal");
        System.out.println(inOrderTraversal(tree) + " Expected: [4, 2, 5, 1, 3, 6]");

        System.out.println("\n\nPre-Order traversal");
        System.out.println(preOrderTraversal(tree) + " Expected: [1, 2, 4, 5, 3, 6]");

        System.out.println("\n\nPost-Order traversal");
        System.out.println(postOrderTraversal(tree) + " Expected: [4, 5, 2, 6, 3, 1]");

        System.out.println("\n\nLevel-Order traversal");
        System.out.println(levelOrderTraversal(tree) + " Expected: [1, 2, 3, 4, 5, 6]");

    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        var collector = new ArrayList<Integer>();
        inOrderTraversal(root, collector);
        return collector;
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> collector) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, collector);
        collector.add(node.val);
        inOrderTraversal(node.right, collector);
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        var collector = new ArrayList<Integer>();
        preOrderTraversal(root, collector);
        return collector;
    }

    private static void preOrderTraversal(TreeNode node, List<Integer> collector) {
        if (node == null) {
            return;
        }
        collector.add(node.val);
        preOrderTraversal(node.left, collector);
        preOrderTraversal(node.right, collector);
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        var collector = new ArrayList<Integer>();
        postOrderTraversal(root, collector);
        return collector;
    }

    private static void postOrderTraversal(TreeNode node, List<Integer> collector) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, collector);
        postOrderTraversal(node.right, collector);
        collector.add(node.val);
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node != null) {
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
