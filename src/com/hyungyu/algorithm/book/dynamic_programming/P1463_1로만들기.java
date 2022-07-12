package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Scanner;

public class P1463_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 연산을 실행 할 정수
        int N = sc.nextInt();
        // DP 를 담을 배열
        int[] D = new int[N + 1];
        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            // -1 연산
            D[i] = D[i - 1] + 1;

            if (i % 2 == 0) {
                // 나누기 2 연산
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                // 나누기 3 연산
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[N]);
    }

}
