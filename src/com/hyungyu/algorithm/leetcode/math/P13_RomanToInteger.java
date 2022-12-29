package com.hyungyu.algorithm.leetcode.math;

public class P13_RomanToInteger {

    public static void main(String[] args) {
//        String s = "III";     // 3
//        String s = "LVIII";   // 58
        String s = "MCMXCIV";   // 1994
        int i = romanToInt(s);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prev = 0;
        int current = 0;
        int length = s.length() - 1;
        for (int i = length; i >= 0; i--) {
            current = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> throw new IllegalArgumentException();
            };
            // 로마 숫자 특성상 높은 숫자가 뒤에 오는 경우는 뺀다.
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }
}
