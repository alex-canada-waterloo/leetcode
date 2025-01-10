package com.naianzin.leetcode.top_interview_150.array_string;

public class ZigZagConversion {


    public String convert(String s, int numRows) {
        int len = s.length();

        int zigzagPointer = 0;
        char[] zigzag = new char[len];

        int stringPointer;
        int maxShift = numRows > 1 ? 2 * numRows - 2 : 1;
        int shift;

        for (int row = 0; row < numRows; row++) {
            stringPointer = row;
            if (stringPointer >= len) {
                break;
            }
            zigzag[zigzagPointer] = s.charAt(stringPointer);
            zigzagPointer++;

            while (zigzagPointer < len) {

                // downward
                shift = maxShift - row * 2;
                if (shift != 0) {
                    stringPointer += shift;
                    if (stringPointer >= len) {
                        break;
                    }
                    zigzag[zigzagPointer] = s.charAt(stringPointer);
                    zigzagPointer++;
                }

                // upward
                shift = row * 2;;
                if (shift != 0) {
                    stringPointer += shift;
                    if (stringPointer >= len) {
                        break;
                    }
                    zigzag[zigzagPointer] = s.charAt(stringPointer);
                    zigzagPointer++;
                }

            }

        }
        return new String(zigzag);
    }


    public static void main(String[] args) {
        var service = new ZigZagConversion();

//        System.out.println(service.convert("1234567890AB", 4) + " ");
        System.out.println(service.convert("AB", 1) + " ");
    }
}
