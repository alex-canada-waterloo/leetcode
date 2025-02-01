package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

import static java.util.Objects.nonNull;

// https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftP = null;
        ListNode rightP = head;
        ListNode leftStartP = null;

        var ordinal = 1;
        while (ordinal <= right) {
            if (ordinal == left - 1) {
                leftStartP = rightP;
            }
            if (ordinal == left) {
                leftP = rightP;
            }
            rightP = rightP.next;
            ++ordinal;
        }

        for (int i = 0; i <= right - left; i++) {
            var tempPointer = leftP.next;
            if (leftStartP == null) {
                head = leftP;
            } else {
                leftStartP.next = leftP;
            }
            leftP.next = rightP;
            rightP = leftP;
            leftP = tempPointer;
        }
        return head;
    }


    public static void main(String[] args) {
        var service = new ReverseLinkedList2();

        var head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, new ListNode(
                                                6, null))))));

        var rotated = service.reverseBetween(head, 1, 6);
        while(nonNull(rotated)) {
            System.out.println(rotated.val);
            rotated = rotated.next;
        }
    }

}
