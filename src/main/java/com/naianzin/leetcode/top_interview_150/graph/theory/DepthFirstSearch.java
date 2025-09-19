package com.naianzin.leetcode.top_interview_150.graph.theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class DepthFirstSearch {

    public void dfs (List<List<Integer>> graph, int nodes, Consumer<Integer> action) {
        var visited = new boolean[nodes];
        dfs(0, graph, visited, action);
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, Consumer<Integer> action) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        action.accept(node);
        for (var neighbor: graph.get(node)) {
            dfs(neighbor, graph, visited, action);
        }
    }

    public static void main(String[] args) {
        var service = new DepthFirstSearch();

        // case 1
        var nodes1 = 5;
        var graph1 = new ArrayList<List<Integer>>(nodes1);
        for (var i = 0; i < nodes1; i++) {
            graph1.add(new ArrayList<>());
        }

        graph1.get(0).add(1);
        graph1.get(0).add(2);
        graph1.get(1).add(3);
        graph1.get(2).add(3);
        graph1.get(3).add(4);

        service.dfs(graph1, nodes1, System.out::println);
    }
}
