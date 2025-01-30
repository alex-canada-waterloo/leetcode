package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

// https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode result = null;
        ListNode resultPointer = new ListNode();
        int sum;
        int l1Val;
        int l2Val;
        while (l1 != null || l2 != null) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;

            sum = l1Val + l2Val + overflow;

            if (sum >= 10) {
                overflow = 1;
                sum -= 10;
            } else {
                overflow = 0;
            }

            if (result == null) {
                result = resultPointer;
            } else {
                result.next = new ListNode();
                result = result.next;
            }

            result.val = sum;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (overflow == 1) {
            result.next = new ListNode(1);
        }
        return resultPointer;
    }
}
