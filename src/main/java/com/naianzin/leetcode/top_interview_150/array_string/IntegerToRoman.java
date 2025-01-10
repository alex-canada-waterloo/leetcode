package com.naianzin.leetcode.top_interview_150.array_string;

public class IntegerToRoman {

    /*
    Seven different symbols represent Roman numerals with the following values:

    Symbol	Value
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1000
    Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
    Converting a decimal place value into a Roman numeral has the following rules:

    If the value does not start with 4 or 9,
    * select the symbol of the maximal value that can be subtracted from the input,
    * append that symbol to the result,
    * subtract its value,
    * and convert the remainder to a Roman numeral.

    If the value starts with 4 or 9
    * use the subtractive form representing one symbol subtracted from the following symbol,
    * for example,
        * 4 is 1 (I) less than 5 (V): IV
        * and 9 is 1 (I) less than 10 (X): IX.
    * Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).

    Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
    You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the
    subtractive form.

    Given an integer, convert it to a Roman numeral.
     */
    public String intToRoman(int num) {
        var sb = new StringBuilder();

        int digit;
        int order = 0;

        while (num != 0) {
            digit = num % 10;
            num /= 10;
            switch (order) {
                case 0 -> {
                    switch (digit) {
                        case 1 -> sb.append("I");
                        case 2 -> sb.append("II");
                        case 3 -> sb.append("III");
                        case 4 -> sb.append("VI"); // reversed
                        case 5 -> sb.append("V");
                        case 6 -> sb.append("IV");
                        case 7 -> sb.append("IIV");
                        case 8 -> sb.append("IIIV");
                        case 9 -> sb.append("XI");
                    }
                } case 1 -> {
                    switch (digit) {
                        case 1 -> sb.append("X");
                        case 2 -> sb.append("XX");
                        case 3 -> sb.append("XXX");
                        case 4 -> sb.append("LX"); // reversed
                        case 5 -> sb.append("L");
                        case 6 -> sb.append("XL"); // reversed
                        case 7 -> sb.append("XXL"); // reversed
                        case 8 -> sb.append("XXXL"); // reversed
                        case 9 -> sb.append("CX"); // reversed
                    }
                } case 2 -> {
                    switch (digit) {
                        case 1 -> sb.append("C");
                        case 2 -> sb.append("CC");
                        case 3 -> sb.append("CCC");
                        case 4 -> sb.append("DC"); // reversed
                        case 5 -> sb.append("D");
                        case 6 -> sb.append("CD"); // reversed
                        case 7 -> sb.append("CCD"); // reversed
                        case 8 -> sb.append("CCCD"); // reversed
                        case 9 -> sb.append("MC"); // reversed
                    }
                } case 3 -> {
                    switch (digit) {
                        case 1 -> sb.append("M");
                        case 2 -> sb.append("MM");
                        case 3 -> sb.append("MMM");
                    }
                }
            }
            order++;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var intToRoman = new IntegerToRoman();

        System.out.println(intToRoman.intToRoman(3749) + " expected: MMMDCCXLIX");
        System.out.println(intToRoman.intToRoman(58) + " expected: LVIII");
        System.out.println(intToRoman.intToRoman(1994) + " expected: MCMXCIV");
    }
}
