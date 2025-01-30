package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
