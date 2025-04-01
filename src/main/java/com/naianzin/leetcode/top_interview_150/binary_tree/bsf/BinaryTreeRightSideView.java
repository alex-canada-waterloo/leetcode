package com.naianzin.leetcode.top_interview_150.binary_tree.bsf;

import com.naianzin.leetcode.util.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.naianzin.leetcode.util.model.TreeNode.arrayToTree;
import static com.naianzin.leetcode.util.print.PrintTree.printTree;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode mostRightNodeOnLevel = null;
        while (!queue.isEmpty()) {
            int nextLevelSize = queue.size();
            for (var i = 0; i < nextLevelSize; i++) {
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

                mostRightNodeOnLevel = node;
            }
            if (mostRightNodeOnLevel != null) {
                result.add(mostRightNodeOnLevel.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var tree = arrayToTree(new Integer[]{1, 2, 3, 4, null, null, null, null, 5});
        printTree(tree);

        var service = new BinaryTreeRightSideView();
        System.out.println(service.rightSideView(tree) + " Expected: [1, 3, 4, 5]");
    }
}
