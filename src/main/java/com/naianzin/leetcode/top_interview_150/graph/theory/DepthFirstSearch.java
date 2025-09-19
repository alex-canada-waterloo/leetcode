package com.naianzin.leetcode.top_interview_150.graph.theory;

import java.util.List;
import java.util.function.Consumer;

import static com.naianzin.leetcode.util.generator.GraphAdjacencyList.graphAdjacencyList6nodes;

public class DepthFirstSearch {

    public void dfs(List<List<Integer>> graph, int nodes, Consumer<Integer> action) {
        var visited = new boolean[nodes];
        dfs(0, graph, visited, action);
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, Consumer<Integer> action) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        action.accept(node);
        for (var neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited, action);
        }
    }

    public static void main(String[] args) {
        var service = new DepthFirstSearch();
        var graph1 = graphAdjacencyList6nodes();
        service.dfs(graph1, 6, System.out::println);
    }
}
