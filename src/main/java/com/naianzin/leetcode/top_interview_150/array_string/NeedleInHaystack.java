package com.naianzin.leetcode.top_interview_150.array_string;

public class NeedleInHaystack {

    public int strStr(String haystack, String needle) {

        var matched = false;
        var index = -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                matched = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        matched = false;
                        break;
                    }
                }

                if (matched) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        var service = new NeedleInHaystack();

        System.out.println(service.strStr("mississippi", "issip") + " expected: 2");
    }
}
