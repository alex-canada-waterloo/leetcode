package com.naianzin.leetcode.util.model;

import com.naianzin.leetcode.util.print.PrintTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTree(Integer[] elements) {
        if (elements.length == 0) {
            return null;
        }
        var root = new TreeNode(elements[0], null, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int rightIndex;

        for (int i = 1; i < elements.length; i += 2) {
            var node = queue.poll();
            if (node == null) {
                continue;
            }

            if (elements[i] != null) {
                var leftNode = new TreeNode(elements[i], null, null);
                node.left = leftNode;
                queue.offer(leftNode);
            } else {
                queue.offer(null);
            }

            rightIndex = i + 1;
            if (rightIndex == elements.length) {
                break;
            }

            if (elements[rightIndex] != null) {
                var rightNode = new TreeNode(elements[rightIndex], null, null);
                node.right = rightNode;
                queue.offer(rightNode);
            } else {
                queue.offer(null);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        var tree = arrayToTree(new Integer[] {
                                  1,
                         2,                  3,
                  4,      null,        null,        7,
                8, 9, null, null,   null, null, null, 15
        });
        PrintTree.printTree(tree);
    }
}
