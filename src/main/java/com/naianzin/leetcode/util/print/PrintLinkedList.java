package com.naianzin.leetcode.util.print;

import com.naianzin.leetcode.util.model.ListNode;

import static java.util.Objects.nonNull;

public class PrintLinkedList {

    private PrintLinkedList() {}

    public static void printLinkedList(ListNode head) {
        var preventInfiniteLoopCounter = 0;
        while(nonNull(head) && preventInfiniteLoopCounter < 50) {
            System.out.print(head.val + " -> ");
            head = head.next;
            ++preventInfiniteLoopCounter;
        }
        System.out.println("null");
    }
}
