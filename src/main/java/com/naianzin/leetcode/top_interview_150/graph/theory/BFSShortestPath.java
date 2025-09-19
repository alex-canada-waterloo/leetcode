package com.naianzin.leetcode.top_interview_150.graph.theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.naianzin.leetcode.util.generator.GraphAdjacencyList.graphAdjacencyList6nodes;

public class BFSShortestPath {

    public List<Integer> shortestPath(List<List<Integer>> graph, int nodes, int from, int to) {
        var visited = new boolean[nodes];
        var queue = new LinkedList<Integer>();
        var path = new ArrayList<Integer>();
        for (var i = 0; i < nodes; i++) {
            path.add(null);
        }

        visited[from] = true;
        queue.add(from);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node == to) {
                break;
            }
            var neighbors = graph.get(node);
            for (var neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    path.set(neighbor, node);
                }
            }
        }
        // reconstruct
        var shortestPath = new ArrayList<Integer>();
        shortestPath.add(to);
        var pointer = to;
        while (pointer != from) {
            pointer = path.get(pointer);
            shortestPath.add(pointer);
        }
        return shortestPath.reversed();
    }

    public static void main(String[] args) {
        var shortestPathService = new BFSShortestPath();
        var graph = graphAdjacencyList6nodes();
        var nodes = 6;
        var from = 0;
        var to = 5;
        var shortestPath = shortestPathService.shortestPath(graph, nodes, from, to);
        System.out.println(shortestPath);
    }
}
