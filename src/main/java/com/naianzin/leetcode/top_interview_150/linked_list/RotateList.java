package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

import static com.naianzin.leetcode.util.print.PrintLinkedList.printLinkedList;

// https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
public class RotateList {



    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        var headPointer = head;
        // iterate on (size - k) node
        var slowPointer = head;
        var fastPointer = head;
        // move fast pointer k nodes forward
        var kOverlap = false;
        var size = 0;
        for (var i = 1; i <= k; i++) {
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                kOverlap = true;
                size = i;
                break;
            }
        }
        if (kOverlap) {
            k = k % size;
            if (k == 0) {
                return head;
            }
            // move fastPointer k nodes forward again
            fastPointer = head;
            for (var i = 1; i <= k; i++) {
                fastPointer = fastPointer.next;
            }
        }
        // move slow pointer to (size - k)
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        headPointer = slowPointer.next;
        slowPointer.next = null;
        fastPointer.next = head;
        return headPointer;
    }

    public static void main(String[] args) {
        var service = new RotateList();
        var head = new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, null)))));
        head = service.rotateRight(head, 6);
        printLinkedList(head);
    }

}
