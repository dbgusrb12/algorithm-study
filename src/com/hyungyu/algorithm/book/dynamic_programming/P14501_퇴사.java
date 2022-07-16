package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Scanner;

public class P14501_퇴사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 퇴사까지 남은 일
        int N = sc.nextInt();
        // 최대 수입
        int[] D = new int[N + 2];
        // 상담 시간
        int[] T = new int[N + 1];
        // 상담 금액
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for (int i = N; i > 0; i--) {
            int consultTime = i + T[i];
            if (consultTime > N + 1) {
                // 해당 상담이 퇴사일까지 끝나지 않는 경우
                D[i] = D[i + 1];
            } else {
                // 해당 상담이 퇴사일까지 끝나는 경우
                D[i] = Math.max(D[i + 1], P[i] + D[consultTime]);
            }
        }
        System.out.println(D[1]);
    }

}
