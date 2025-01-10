package com.naianzin.leetcode.top_interview_150.array_string;

public class RomanToInteger {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is
    simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
    IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX. There are six instances where
    subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

     */
    public int romanToInt(String s) {
        var number = 0;
        var lastIndex = s.length() - 1;
        Character nextChar;
        for (int i = 0; i <= lastIndex; i++) {

            nextChar = i < lastIndex ? s.charAt(i + 1) : null;

            switch (s.charAt(i)) {
                case 'I' -> {
                    if (nextChar != null && 'V' == nextChar) {
                        number += 4;
                        i++;
                    } else if (nextChar != null && 'X' == nextChar) {
                        number += 9;
                        i++;
                    } else {
                        number++;
                    }
                }
                case 'V' -> {
                    number += 5;
                } case 'X' -> {
                    if (nextChar != null && 'L' == nextChar) {
                        number += 40;
                        i++;
                    } else if (nextChar != null && 'C' == nextChar) {
                        number += 90;
                        i++;
                    } else {
                        number += 10;
                    }
                } case 'L' -> {
                    number += 50;
                } case 'C' -> {
                    if (nextChar != null && 'D' == nextChar) {
                        number += 400;
                        i++;
                    } else if (nextChar != null && 'M' == nextChar) {
                        number += 900;
                        i++;
                    } else {
                        number += 100;
                    }
                } case 'D' -> {
                    number += 500;
                } case 'M' -> {
                    number += 1000;
                }
            }
        }

        return number;
    }

    public static void main(String[] args) {
        var romainToInteger = new RomanToInteger();

        System.out.println(romainToInteger.romanToInt("III") + " expected: 3");
        System.out.println(romainToInteger.romanToInt("MCMXCIV") + " expected: 1994");
    }
}
