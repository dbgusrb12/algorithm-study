package com.hyungyu.algorithm.leetcode.math;

public class P67_AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String answer = addBinary(a, b);
        System.out.println(answer);
    }

    public static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int sum = 0;

        while (aLength >= 0 || bLength >= 0) {
            if (aLength >= 0) {
                // a 의 숫자 합산
                sum += a.charAt(aLength--) - '0';
            }
            if (bLength >= 0) {
                // b 의 숫자 합산
                sum += b.charAt(bLength--) - '0';
            }
            // % 2 로 2진법 해당 자릿수 구함
            stringBuilder.append(sum % 2);
            // / 2 로 2진법 올림수 구함
            sum /= 2;
        }
        if (sum > 0) {
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }
}
