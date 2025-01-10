package com.naianzin.leetcode.util.print;

public class PrintBits {

    private PrintBits() {}

    public static void printBits(int number) {
        var sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            sb.append(bit);
            if (i % 4 == 0) {
                sb.append("  ");
            }
        }
        System.out.printf("Decimal: %2d, Binary: %s%n", number, sb);
    }

    public static void main(String[] args) {
        int a = 1;
        printBits(a);
    }
}
