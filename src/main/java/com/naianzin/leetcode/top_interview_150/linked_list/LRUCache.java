package com.naianzin.leetcode.top_interview_150.linked_list;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
public class LRUCache {

    private static class Entry {
        public int key;
        public int val;
        public Entry prev;
        public Entry next;
    }

    private final HashMap<Integer, Entry> map;
    private final int capacity;
    private Entry head;
    private Entry tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity, 1.0F);
    }

    public int get(int key) {
        var entry = map.get(key);
        if (entry == null) {
            return -1;
        }
        updateUsage(entry);
        return entry.val;
    }

    public void put(int key, int value) {
       var entry = map.get(key);
       if (entry == null) {
           insertNewKey(key, value);
       } else {
           updateExistingEntry(entry, value);
       }
    }

    private void updateExistingEntry(Entry entry, int value) {
        entry.val = value;
        updateUsage(entry);
    }

    private void updateUsage(Entry entry) {
        if (entry == head) {
            return;
        }

        // remove node
        if (entry == tail) {
            tail.prev.next = null;
            tail = tail.prev;
            entry.prev = null;
            entry.next = null;
        } else {
            var leftEntry = entry.prev;
            var rightEntry = entry.next;
            entry.prev = null;
            entry.next = null;

            if (leftEntry != null) {
                leftEntry.next = rightEntry;
            }

            if (rightEntry != null) {
                rightEntry.prev = leftEntry;
            }
        }


        // Insert node at head
        if (head != null) {
            entry.next = head;
            head.prev = entry;
            head = entry;
        }
    }

    private void insertNewKey(int key, int value) {

        ensureCapacity();

        var entry = new Entry();
        entry.key = key;
        entry.val = value;
        map.put(key, entry);

        // new key to head
        if (head != null) {
            entry.next = head;
            head.prev = entry;
        } else {
            tail = entry;
        }
        head = entry;
    }

    private void ensureCapacity() {
        if (map.size() == this.capacity) {
            map.remove(tail.key);
            if (map.isEmpty()) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public static void main(String[] args) {

        var cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1) + " Expected: 1");
        cache.put(3,3);
        System.out.println(cache.get(2) + " Expected: -1");
        cache.put(4,4);
        System.out.println(cache.get(1) + " Expected: -1");
        System.out.println(cache.get(3) + " Expected: 3");
        System.out.println(cache.get(4) + " Expected: 4");

        var cache2 = new LRUCache(2);
        cache2.put(2,1);
        cache2.put(1,1);
        cache2.put(2,3);
        cache2.put(4,1);
        System.out.println(cache2.get(1) + " Expected: -1");
        System.out.println(cache2.get(2) + " Expected: 3");



    }
}
