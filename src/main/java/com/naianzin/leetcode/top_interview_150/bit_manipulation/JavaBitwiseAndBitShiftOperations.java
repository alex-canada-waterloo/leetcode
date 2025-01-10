package com.naianzin.leetcode.top_interview_150.bit_manipulation;

import static com.naianzin.leetcode.util.print.PrintBits.printBits;
import static java.lang.System.out;

public class JavaBitwiseAndBitShiftOperations {

    public static void main(String[] args) {

        out.println("~ inverts all bits");
        int invert = 1;
        printBits(invert);
        printBits(~invert);
        out.println();

        out.println("<< signed left shift, basically multiplying by the integer by 2");
        int leftShift = 1;
        printBits(leftShift);
        printBits(leftShift << 1);
        out.println();

        out.println(">> signed right shift, division by 2");
        int rightShift = 10;
        printBits(rightShift);
        printBits(rightShift >> 1);
        out.println();

        out.println("Difference between >> and >>>");
        printBits(1 >> 2);
        printBits(-1 >>> 2);
        out.println(-1 >>> 2);
        out.println();

        out.println("& - AND");
        printBits(101);
        printBits(1);
        printBits(101 & 1);
        out.println();

        out.println("^ -  XOR, 1 ^ 1 = 0");
        printBits(101);
        printBits(1);
        printBits(101 ^ 1);
        out.println();

        out.println("| - inclusive OR, 1 | 1 = 1");
        printBits(101);
        printBits(1);
        printBits(101 | 1);
        out.println();

        out.println("Binary inline");
        out.println(0B101);
        out.println();

        out.println("Octal inline");
        out.println(015);
        out.println();

        out.println("Hexadecimal, 0-9ABCDEF");
        out.println(0xF);
        out.println();

        out.println("Get the rightmost bit");
        printBits(0B101 & 1);
        printBits(0B100 & 1);
        printBits(-0B101 & 1);
        out.println();

        out.println("Set the rightmost bit to 1");
        printBits(0B100 | 1);
        printBits(-0B100 | 1);
        out.println();

        out.println("Set the rightmost bit to 0");
        printBits(0B101 & ~1);
        out.println();

        out.println("XOR one more time");
        printBits(0B0 ^ 0B0);
        printBits(0B0 ^ 0B1);
        printBits(0B1 ^ 0B1);
    }
}
