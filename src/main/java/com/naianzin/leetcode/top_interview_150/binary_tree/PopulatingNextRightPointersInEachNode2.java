package com.naianzin.leetcode.top_interview_150.binary_tree;


import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode2 {

    public static class Node {
        int val;
        Node left, right, next;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        var queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (prevNode != null) {
                    prevNode.next = node;
                }
                prevNode = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
