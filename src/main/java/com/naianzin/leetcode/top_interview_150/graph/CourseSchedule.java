package com.naianzin.leetcode.top_interview_150.graph;

import java.util.*;


// https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
public class CourseSchedule {

    private Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    private Set<Integer> seen = new HashSet<>();

    public boolean canFinish(int numCourses, int[][]prerequisites) {

        // Build navigable adjacencyMap

        for (var coursePrerequisite : prerequisites) {
            var course = coursePrerequisite[0];
            var prerequisite = coursePrerequisite[1];
            adjacencyMap
                    .computeIfAbsent(course, k -> new ArrayList<>())
                    .add(prerequisite);
        }

        // BFS to check if all courses are finishable
        var result = true;
        for (var course : adjacencyMap.keySet()) {
            //seen.clear();
            result = result && dfs(course);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (!adjacencyMap.containsKey(course)) {
            return true;
        }

        var coursePrerequisites = adjacencyMap.get(course);
        var it = coursePrerequisites.iterator();
        var result = true;
        while (it.hasNext()) {
            var coursePrerequisite = it.next();
            if (seen.contains(coursePrerequisite)) {
                return false;
            }
            seen.add(coursePrerequisite);
            it.remove();
            result = result && dfs(coursePrerequisite);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var service = new CourseSchedule();

//        var prerequisites1 = new int[][] {{1, 0}};
//        System.out.println(service.canFinish(2, prerequisites1) + " Expected: true");

        var prerequisites2 = new int[][] {{1, 0}, {0, 1}};
        System.out.println(service.canFinish(2, prerequisites2) + " Expected: false");
//
//        var prerequisites3 = new int[][] {{1,4},{2,4},{3,1},{3,2}};
//        System.out.println(service.canFinish(5, prerequisites3) + " Expected: true");
    }
}
