package com.naianzin.leetcode.top_interview_150.array_string;

public class IntegerToRoman2 {

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
    int[] values = new int[] { 1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,  5,     4,  1};
    String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        var sb = new StringBuilder();
        var p = 0;
        int value;
        while (num > 0) {
            value = values[p];
            if (num >= value) {
                sb.append(roman[p]);
                num -= value;
            } else {
                p++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var intToRoman2 = new IntegerToRoman2();

        System.out.println(intToRoman2.intToRoman(3749) + " expected: MMMDCCXLIX");
        System.out.println(intToRoman2.intToRoman(58) + " expected: LVIII");
        System.out.println(intToRoman2.intToRoman(1994) + " expected: MCMXCIV");
    }
}
