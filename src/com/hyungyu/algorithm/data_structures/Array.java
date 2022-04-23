package com.hyungyu.algorithm.data_structures;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
    }

    /**
     * 숫자의 합 구하기
     */
    public void sum() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String numString = sc.next();
        char[] chars = numString.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i] - '0';
            // 이렇게도 쓸 수 있다.
            // sum += Character.getNumericValue(chars[i]);
        }
        System.out.println(sum);
    }
}
