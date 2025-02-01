package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

import static java.util.Objects.nonNull;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
public class RemoveNthNodeFromTheEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        var dummy = new ListNode();
        dummy.next = head;
        var forwardPointer = dummy;
        var backPointer = dummy;

        // move fast pointer n nodes forward
        for (int i = 0; i <= n; i++) {
            forwardPointer = forwardPointer.next;
        }

        // move fast and slow pointers forward until fast pointer reaches the end
        // the slow pointer will be on size - n element
        while(forwardPointer != null) {
            forwardPointer = forwardPointer.next;
            backPointer = backPointer.next;
        }
        backPointer.next = backPointer.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        var service = new RemoveNthNodeFromTheEnd();

        var head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, new ListNode(
                                                6, null))))));

        var rotated = service.removeNthFromEnd(head, 6);
        while(nonNull(rotated)) {
            System.out.println(rotated.val);
            rotated = rotated.next;
        }
    }
}
