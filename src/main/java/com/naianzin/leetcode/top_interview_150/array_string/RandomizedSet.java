package com.naianzin.leetcode.top_interview_150.array_string;

import java.util.*;

import static java.lang.System.out;

/*
    https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
    You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    // Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    // Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (map.size() == 1) {
            map.clear();
            list.clear();
            return true;
        }
        int listRemoveIndex = map.remove(val);
        if (listRemoveIndex == list.size() - 1) {
            list.removeLast();
        } else {
            int listLastElement = list.removeLast();
            list.set(listRemoveIndex, listLastElement);
            map.put(listLastElement, listRemoveIndex);
        }
        return true;
    }

    // Returns a random element from the current set of elements (it's guaranteed that at least one element exists when
    // this method is called). Each element must have the same probability of being returned.
    public int getRandom() {
        var randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        var set1 = new RandomizedSet();
        out.println(set1.insert(1) + " expected true");
        out.println(set1.remove(2) + " expected false");
        out.println(set1.insert(2) + " expected true");
        out.println(set1.getRandom() + " expected 1 or 2");
        out.println(set1.remove(1) + " expected true");
        out.println(set1.insert(2) + " expected false");
        out.println(set1.getRandom() + " expected 2");

        var set2 = new RandomizedSet();
        out.println(set2.insert(0) + " expected true");
        out.println(set2.remove(0) + " expected true");
        out.println(set2.insert(0) + " expected true");

        var set3 = new RandomizedSet();
        out.println(set3.insert(0) + " expected true");
        out.println(set3.insert(1) + " expected true");
        out.println(set3.insert(2) + " expected true");
        out.println(set3.insert(3) + " expected true");
        out.println(set3.insert(4) + " expected true");
        out.println(set3.remove(0) + " expected true");
        out.println(set3.remove(1) + " expected true");

        var set4 = new RandomizedSet();
        set4.insert(3);
        set4.insert(3);
        set4.insert(1);
        set4.remove(2);
        set4.insert(0);
        set4.remove(0);

    }
}
