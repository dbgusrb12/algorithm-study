package com.hyungyu.algorithm.book.array_and_list;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] chars = sNum.toCharArray();
        // 반복문 돌 때 배열에 계속 접근하기 보다 변수에 할당해서 쓰는게 좋음.
        int length = chars.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += chars[i] - '0';
            // 이렇게도 쓸 수 있다.
            // sum += Character.getNumericValue(chars[i]);
        }
        System.out.println(sum);
    }
}
