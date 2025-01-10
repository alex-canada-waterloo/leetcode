package com.naianzin.leetcode.top_interview_150.linked_list;

public class MegeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(){}

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        var result = new ListNode();
        var tail = result;
        var p1 = list1;
        var p2 = list2;
        int v1 = p1.val;
        int v2 = p2.val;

        if (v1 < v2) {
            result.val = v1;
            p1 = p1.next;
        } else {
            result.val = v2;
            p2 = p2.next;
        }
        ListNode newNode;
        while (p1 != null && p2 != null) {
            newNode = new ListNode();
            if (p1.val < p2.val) {
                newNode.val = p1.val;
                p1 = p1.next;
            } else {
                newNode.val = p2.val;
                p2 = p2.next;
            }
            tail.next = newNode;
            tail = newNode;
        }
        if (p1 != null) {
            tail.next = p1;
        } else if (p2 != null) {
            tail.next = p2;
        }
        return result;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        var service = new MegeTwoSortedLists();
        var result = service.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
