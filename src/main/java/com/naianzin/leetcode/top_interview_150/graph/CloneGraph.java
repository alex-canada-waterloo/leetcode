package com.naianzin.leetcode.top_interview_150.graph;

import com.naianzin.leetcode.util.model.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    private final Map<Node, Node> map = new HashMap<>();
    private final Queue<Node> queue = new LinkedList<>();

    public Node cloneGraph(Node node) {
        return cloneDfs(node);
//        return cloneBfs(node);
    }

    public Node cloneBfs(Node node) {
        var root = new Node(node.val);
        map.put(node, root);
        queue.add(node);
        while (!queue.isEmpty()) {

        }
        return root;
    }

    public Node cloneDfs(Node node) {
        if (node == null) {
            return null;
        }
        var cloneNode = map.get(node);
        if (cloneNode == null) {
            cloneNode = new Node(node.val);
            map.put(node, cloneNode);
            for (var neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
        }
        return cloneNode;
    }
}
