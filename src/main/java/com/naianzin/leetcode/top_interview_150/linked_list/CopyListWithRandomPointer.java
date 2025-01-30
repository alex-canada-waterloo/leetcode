package com.naianzin.leetcode.top_interview_150.linked_list;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> originalToNewMapping = new HashMap<>();

        var headPointer = head;
        var randomPointer = head;

        Node result = null;
        Node resultPointer = null;
        Node resultRandomPointer;

        while (headPointer != null) {

            if (resultPointer == null) {
                resultPointer = new Node(headPointer.val);
                result = resultPointer;
            } else {
                if (originalToNewMapping.containsKey(headPointer)) {
                    resultPointer.next = originalToNewMapping.get(headPointer);
                } else {
                    resultPointer.next = new Node(headPointer.val);
                }
                resultPointer = resultPointer.next;
            }

            originalToNewMapping.put(headPointer, resultPointer);

            randomPointer = headPointer.random;
            resultRandomPointer = resultPointer;
            while (randomPointer != null) {
                if (originalToNewMapping.containsKey(randomPointer)) {
                    resultRandomPointer.random = originalToNewMapping.get(randomPointer);
                    break;
                } else {
                    resultRandomPointer.random = new Node(randomPointer.val);
                    resultRandomPointer = resultRandomPointer.random;
                    originalToNewMapping.put(randomPointer, resultRandomPointer);
                    randomPointer = resultPointer.next;
                }
            }

            headPointer = headPointer.next;
        }

        return result;
    }

    public static void main(String[] args) {
        var service = new CopyListWithRandomPointer();

        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        var node7 = new Node(7);
        var node13 = new Node(13);
        var node11 = new Node(11);
        var node10 = new Node(10);
        var node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        var result = service.copyRandomList(node7);
        var it = result;
        while (it != null) {
            var random = it.random;
            if (random != null) {
                System.out.println(it.val + " " + random.val);
            } else {
                System.out.println(it.val + " null");
            }

            it = it.next;
        }
        // [[7,null],
        // [13,0],
        // [11,4],
        // [10,2],
        // [1,0]]
    }

}
