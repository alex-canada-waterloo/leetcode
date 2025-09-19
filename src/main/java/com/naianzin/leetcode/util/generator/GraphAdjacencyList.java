package com.naianzin.leetcode.util.generator;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {

    public static List<List<Integer>> graphAdjacencyList6nodes() {
        var nodes = 6;
        var graph = new ArrayList<List<Integer>>(nodes);
        for (var i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(4);
        graph.get(5).add(5);
        return graph;
    }
}
