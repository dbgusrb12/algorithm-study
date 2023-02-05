package com.hyungyu.algorithm.leetcode.string;

public class P58_LengthOfLastWord {

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int wordLength = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if (aChar != ' ') {
                wordLength++;
                continue;
            }

            if (wordLength > 0) {
                return wordLength;
            }
        }
        return wordLength;
    }
}
