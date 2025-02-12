package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

import static com.naianzin.leetcode.util.print.PrintLinkedList.printLinkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        var service = new RemoveDuplicatesFromSortedList();

        var head = new ListNode(
                1, new ListNode(
                1, new ListNode(
                2, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, new ListNode(
                6, new ListNode(
                6, new ListNode(
                7, null))))))))));

        head = service.deleteDuplicates(head);

        printLinkedList(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var dummy = new ListNode();
        ListNode dummyPointer = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        boolean isDuplicate = false;
        while (p2 != null) {
            if (p1.val == p2.val) {
                isDuplicate = true;
                p2 = p2.next;
            } else {
                if (isDuplicate) {
                    p1 = p2;
                    p2 = p2.next;
                    isDuplicate = false;
                } else {
                    dummyPointer.next = p1;
                    dummyPointer = dummyPointer.next;
                    p1 = p2;
                    p2 = p2.next;
                }
            }
        }
        if (!isDuplicate) {
            // flush last node
            dummyPointer.next = p1;
            dummyPointer = dummyPointer.next;
        }
        dummyPointer.next = null;
        return dummy.next;
    }
}
