package com.hyungyu.algorithm.leetcode.string;

import java.util.Arrays;

public class P14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"abab", "aba", "abc"};
        String s = longestCommonPrefix(strs);
        String s2 = longestCommonPrefix2(strs);
        System.out.println(s);
        System.out.println(s2);
    }

    public static String longestCommonPrefix(String[] strs) {
        String firstWords = strs[0];
        int length = firstWords.length();
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() == i || ch != str.charAt(i)) {
                    return firstWords.substring(0, i);
                }
            }
        }
        return firstWords;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c)) {
                c++;
            } else {
                break;
            }
        }
        return c == 0 ? "" : first.substring(0, c);
    }
}
