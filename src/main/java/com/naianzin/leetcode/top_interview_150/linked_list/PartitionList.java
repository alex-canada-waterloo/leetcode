package com.naianzin.leetcode.top_interview_150.linked_list;

import com.naianzin.leetcode.util.model.ListNode;

import static com.naianzin.leetcode.util.print.PrintLinkedList.printLinkedList;

//https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        var leftPartitionPointer = new ListNode();
        var rightPartitionPointer = new ListNode();
        var leftPartitionHead = leftPartitionPointer;
        var rightPartitionHead = rightPartitionPointer;
        while (head != null) {
            if (head.val < x) {
                leftPartitionPointer.next = head;
                leftPartitionPointer = leftPartitionPointer.next;
            } else {
                rightPartitionPointer.next = head;
                rightPartitionPointer = rightPartitionPointer.next;
            }
            head = head.next;
        }
        leftPartitionPointer.next = rightPartitionHead.next;
        rightPartitionPointer.next = null;
        return leftPartitionHead.next;
    }

    public static void main(String[] args) {
        var service = new PartitionList();
        var head = new ListNode(
                1, new ListNode(
                4, new ListNode(
                3, new ListNode(
                2, new ListNode(
                5, new ListNode(
                2, null))))));
        var partitioned = service.partition(head, 3);
        printLinkedList(partitioned);
    }
}
