package com.naianzin.leetcode.top_interview_150.graph.theory;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static com.naianzin.leetcode.util.generator.GraphAdjacencyList.graphAdjacencyList6nodes;

public class BreadthFirstSearch {

    public void bfs(List<List<Integer>> graph, int nodes, Consumer<Integer> action) {
        var queue = new LinkedList<Integer>();
        var visited = new boolean[nodes];

        // take first node
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            action.accept(node);
            var neighbors = graph.get(node);
            for (var neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        var bfsService = new BreadthFirstSearch();
        var graph = graphAdjacencyList6nodes();
        bfsService.bfs(graph, 6, System.out::println);
    }
}
