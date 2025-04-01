package com.naianzin.leetcode.top_interview_150.binary_tree.bsf;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.naianzin.leetcode.util.model.TreeNode.arrayToTree;
import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var fromLeftToRight = true;
        while (!queue.isEmpty()) {
            var level = new LinkedList<Integer>();
            var levelSize = queue.size();
            for (var i = 0; i < levelSize; i++) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (fromLeftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
            }
            result.add(level);
            fromLeftToRight = !fromLeftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        var tree = arrayToTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        printTree(tree);

        var service = new BinaryTreeZigZagLevelOrderTraversal();
        var levelOrder = service.zigzagLevelOrder(tree);
        System.out.println(levelOrder.get(0) + " Expected: [1]");
        System.out.println(levelOrder.get(1) + " Expected: [3, 2]");
        System.out.println(levelOrder.get(2) + " Expected: [4, 5, 6, 7]");
        System.out.println(levelOrder.get(3) + " Expected: [9, 8]");
    }
}
