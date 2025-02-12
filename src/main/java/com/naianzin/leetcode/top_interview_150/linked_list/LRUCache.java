package com.naianzin.leetcode.top_interview_150.linked_list;

import java.util.HashMap;
import java.util.LinkedHashMap;

// https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
public class LRUCache {

    private static class Entry {
        public int key;
        public int val;
        public Entry prev;
        public Entry next;
    }

    private HashMap<Integer, Entry> map;
    private Entry head;
    private Entry tail;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity, 1.0F);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            var entry = map.get(key);

            if (head == entry) {
                return entry.val;
            } else if (tail == entry) {
                tail = entry.prev;
                entry.next = head;
                head.prev = entry;
                head = entry;
            } else {
                entry.prev.next = entry.next;
                entry.next.prev = entry.prev;
                entry.next = head;
                head.prev = entry;
                head = entry;
            }

            return entry.val;

        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        var entry = new Entry();
        entry.key = key;
        entry.val = value;
        if (head == null) {
            head = entry;
        } else {
            entry.next = head;
            head.prev = entry;
            head = entry;
        }
        if (tail == null) {
            tail = entry;
        }
        map.put(key, entry);

        if (map.size() == capacity) {
            map.remove(tail.key);
            if (tail.prev != null) {
                tail = tail.prev;
            }
        }
    }

    public static void main(String[] args) {

        var cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1) + " Expected: -1");
        System.out.println(cache.get(2) + " Expected: 3");
    }
}
