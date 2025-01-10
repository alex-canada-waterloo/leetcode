package com.naianzin.leetcode.top_interview_150.binary_tree.bsf;


import com.naianzin.leetcode.util.model.TreeNode;

import java.util.*;

public class AverageOfLevels {

    public static void main(String[] args) {
        var root = new TreeNode(3,
                new TreeNode(9, null, null),
                new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        var service = new AverageOfLevels();
        System.out.println(service.averageOfLevels(root) + " Expected: [3, 14.5, 11]");
    }

    public List<Double> averageOfLevels(TreeNode root) {
        return new AbstractList<>() {

            private List<Double> averages;

            @Override
            public int size() {
                if (averages == null) {
                    this.averages = countAverageOfLevels(root);
                }
                return averages.size();
            }

            @Override
            public Double get(int index) {
                if (averages == null) {
                    this.averages = countAverageOfLevels(root);
                }
                return averages.get(index);
            }
        };
    }

    private List<Double> countAverageOfLevels(TreeNode root) {
        var averages = new ArrayList<Double>();
        if (root == null) {
            return averages;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        var sum = 0D;
        var levelSize = 1;
        TreeNode currNode;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            for (var i = 0; i < levelSize; i++) {
                currNode = queue.poll();
                sum += currNode.val;
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            averages.add(sum / levelSize);
            sum = 0D;
        }
        return averages;
    }
}
