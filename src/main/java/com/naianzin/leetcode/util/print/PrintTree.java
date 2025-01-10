package com.naianzin.leetcode.util.print;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    private PrintTree() {}


    private static Queue<TreeNode> queue = new LinkedList<>();

    public static void printTreeAsc(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        int size;
        TreeNode node;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (var i = 0; i < size; i++) {
                node = queue.poll();
                System.out.print(node.val + "    ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println(" ");
        }
    }
}
