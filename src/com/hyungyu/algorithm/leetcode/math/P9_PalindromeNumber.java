package com.hyungyu.algorithm.leetcode.math;

public class P9_PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        boolean palindrome = isPalindrome(x);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        // 음수 일 경우 false
        if (x < 0) {
            return false;
        }
        // 1의 자리 숫자일 경우 true
        if (x < 10) {
            return true;
        }
        // 10으로 나누어 떨어질 경우 false
        if (x % 10 == 0) {
            return false;
        }

        int reverseX = 0;
        while (x > reverseX) {
            // x의 1의 자리 부터 대입
            reverseX = reverseX * 10 + x % 10;
            // x의 1의 자리 삭제
            x /= 10;
        }

        // 자릿수가 짝수 일 경우 그냥 비교, 자릿수가 홀수 일 경우 한번 더 연산 후 비교
        return reverseX == x || reverseX / 10 == x;
    }
}
