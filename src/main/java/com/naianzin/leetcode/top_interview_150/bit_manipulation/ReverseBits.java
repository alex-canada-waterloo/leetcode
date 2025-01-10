package com.naianzin.leetcode.top_interview_150.bit_manipulation;

import static com.naianzin.leetcode.util.print.PrintBits.printBits;

public class ReverseBits {

    // https://leetcode.com/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150
    public int reverseBits(int n) {
        int result = 0;
        for (var i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        var service = new ReverseBits();
        printBits(service.reverseBits(0B101));
        System.out.println("Expected:                     1010  0000  0000  0000  0000  0000  0000  0000");

        System.out.println();

        printBits(service.reverseBits(0B11111111111111111111111111111101));
        System.out.println("Expected                      1011  1111  1111  1111  1111  1111  1111  1111");
    }

}
