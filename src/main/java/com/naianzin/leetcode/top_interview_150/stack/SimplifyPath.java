package com.naianzin.leetcode.top_interview_150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        var components = path.split("/");
        for (var component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        var sb = new StringBuilder();
        for (var component : stack.reversed()) {
            sb.append("/").append(component);
        }
        if (sb.isEmpty()) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var service = new SimplifyPath();
//        System.out.println(service.simplifyPath(
//                "/home/") + " Expected: /home");
//        System.out.println(service.simplifyPath(
//                "/home//foo/") + " Expected: /home/foo");
        System.out.println(service.simplifyPath(
                "/home/user/Documents/../Pictures") + " Expected: /home/user/Pictures");
//        System.out.println(service.simplifyPath(
//                "/../") + " Expected: /");
//        System.out.println(service.simplifyPath(
//                "/.../a/../b/c/../d/./") + " Expected: /.../b/d");
    }
}
