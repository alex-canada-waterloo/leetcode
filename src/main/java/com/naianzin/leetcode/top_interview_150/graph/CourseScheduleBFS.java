package com.naianzin.leetcode.top_interview_150.graph;

import java.util.*;
import java.util.stream.Collectors;


// https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
public class CourseScheduleBFS {

    private Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
    private Map<Integer, List<Integer>> invertedAdjacencyMap = new HashMap<>();
    private Queue<Integer> bfsQueue = new LinkedList<>();

    public boolean canFinish(int numCourses, int[][]prerequisites) {
        // build adjacency map and inverted adjacency map
        for (var prerequisitePair : prerequisites) {
            var course = prerequisitePair[0];
            var prerequisite = prerequisitePair[1];
            adjacencyMap.computeIfAbsent(course, (k) -> new HashSet<>()).add(prerequisite);
            adjacencyMap.putIfAbsent(prerequisite, new HashSet<>());

            invertedAdjacencyMap.computeIfAbsent(prerequisite, (k) -> new ArrayList<>()).add(course);
            invertedAdjacencyMap.putIfAbsent(course, new ArrayList<>());
        }

        // populate the queue with the courses having no prerequisites
        adjacencyMap.entrySet().stream()
                .filter(e -> e.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(() -> bfsQueue));

        // bfs queue removing
        while (!bfsQueue.isEmpty()) {
            var prerequisite = bfsQueue.poll();


            adjacencyMap.remove(prerequisite);

            var dependantCourses = invertedAdjacencyMap.remove(prerequisite);
            for (var dependantCourse : dependantCourses) {
                var dependantCoursePrerequisites = adjacencyMap.get(dependantCourse);
                dependantCoursePrerequisites.remove(prerequisite);
                if (dependantCoursePrerequisites.isEmpty()) {
                    bfsQueue.add(dependantCourse);
                }
            }
        }

        return adjacencyMap.isEmpty();
    }


    public static void main(String[] args) {
        var service = new CourseScheduleBFS();

        var prerequisites1 = new int[][] {{1, 0}};
        System.out.println(service.canFinish(2, prerequisites1) + " Expected: true");

        var prerequisites2 = new int[][] {{1, 0}, {0, 1}};
        System.out.println(service.canFinish(2, prerequisites2) + " Expected: false");

        var prerequisites3 = new int[][] {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(service.canFinish(5, prerequisites3) + " Expected: true");
    }
}
