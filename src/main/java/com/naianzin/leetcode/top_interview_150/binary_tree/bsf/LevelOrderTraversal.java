package com.naianzin.leetcode.top_interview_150.binary_tree.bsf;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.naianzin.leetcode.util.model.TreeNode.arrayToTree;
import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var level = new ArrayList<Integer>();
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
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        var tree = arrayToTree(new Integer[]{1, 2, 3, 4, null, null, null, null, 5});
        printTree(tree);

        var service = new LevelOrderTraversal();
        var levelOrder = service.levelOrder(tree);
        System.out.println(levelOrder.get(0) + " Expected: [1]");
        System.out.println(levelOrder.get(1) + " Expected: [2, 3]");
        System.out.println(levelOrder.get(2) + " Expected: [4]");
        System.out.println(levelOrder.get(3) + " Expected: [5]");
    }
}
