package com.naianzin.leetcode.util.model;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
