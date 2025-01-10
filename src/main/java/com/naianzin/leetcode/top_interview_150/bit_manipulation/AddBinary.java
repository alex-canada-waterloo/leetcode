package com.naianzin.leetcode.top_interview_150.bit_manipulation;

import java.util.Arrays;

public class AddBinary {

    // https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
    public String addBinary(String a, String b) {
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        byte carry = (byte) 0;
        byte sum = (byte) 0;
        var result = new StringBuilder();
        while (aPointer >= 0 || bPointer >= 0 || carry > 0) {
            if (aPointer >= 0) {
                sum += (byte) (a.charAt(aPointer) - '0');
            }
            if (bPointer >= 0) {
                sum += (byte) (b.charAt(bPointer) - '0');
            }
            if (carry > 0) {
                sum += 1;
                carry = 0;
            }
            switch (sum) {
                case (byte) 0 -> result.append('0');
                case (byte) 1 -> result.append('1');
                case (byte) 2 -> {
                    result.append('0');
                    carry = 1;
                }
                case (byte) 3 -> {
                    result.append('1');
                    carry = 1;
                }
            }
            aPointer --;
            bPointer --;
            sum = 0;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        var service = new AddBinary();

//        System.out.println(service.addBinary("11", "1") + " Expected: 100");
//        System.out.println(service.addBinary("1010", "1011") + " Expected: 10101");
        System.out.println(service.addBinary("11", "11") + " Expected: 110");
    }
}
