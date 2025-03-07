package com.naianzin.leetcode.util.print;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {

    private PrintTree() {}

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        List<List<TreeNode>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            levels.add(level);
        }

        int maxWidth = (int) Math.pow(2, levels.size()) * 4; // Max spacing for neat formatting

        for (int i = 0; i < levels.size(); i++) {
            List<TreeNode> level = levels.get(i);
            int spaceBetween = maxWidth / (level.size() + 1);

            // Print nodes
            for (TreeNode node : level) {
                System.out.printf("%" + spaceBetween + "s", (node != null ? node.val : "null"));
            }
            System.out.println();

            if (i < levels.size() - 1) {
                // Print connectors (arrows)
                for (int j = 0; j < level.size(); j++) {
                    System.out.printf("%" + (spaceBetween - 2) + "s/\\", " ");
                }
                System.out.println();
            }
        }
    }
}
