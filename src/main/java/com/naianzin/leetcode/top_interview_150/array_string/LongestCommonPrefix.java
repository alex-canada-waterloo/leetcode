package com.naianzin.leetcode.top_interview_150.array_string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        char ch = '1';
        var prefix = 0;
        var limit = Integer.MAX_VALUE;
        for (var str : strs) {
            if (str.length() < limit) {
                limit = str.length();
            }
        }
        var stop = false;
        for (int i = 0; i < limit; i++) {

            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    ch = strs[j].charAt(i);
                    continue;
                }
                if (strs[j].charAt(i) != ch) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            prefix++;
        }
        return strs[0].substring(0, prefix);
    }

    public static void main(String[] args) {
        var service = new LongestCommonPrefix();
        System.out.println(service.longestCommonPrefix(new String[] {"flower","flow","flight"}) + " Expected: fl");
    }
}
