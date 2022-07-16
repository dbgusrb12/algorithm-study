package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Scanner;

public class P1915_가장큰정사각형 {

    public static void main(String[] args) {
        // 최대값 저장
        long[][] DP = new long[1001][1001];
        Scanner sc = new Scanner(System.in);
        // 가로 길이
        int N = sc.nextInt();
        // 세로 길이
        int M = sc.nextInt();
        long max = 0;
        for (int i = 0; i < N; i++) {
            char[] horizontalLine = sc.next().toCharArray();
            for (int j = 0; j < M; j++) {
                DP[i][j] = horizontalLine[j] - '0';
                if (DP[i][j] == 1 && j > 0 && i > 0) {
                    // DP[i][j] 값이 1이면 위, 왼쪽, 왼쪽 위의 값들 중 최속값 + 1 저장 (첫번쨰 라인은 제외)
                    // 왼쪽 값
                    long leftValue = DP[i][j - 1];
                    // 위쪽 값
                    long topValue = DP[i - 1][j];
                    // 왼쪽 위 값
                    long leftTopValue = DP[i - 1][j - 1];
                    // 세 값들 중 최솟값 + 1
                    DP[i][j] = Math.min(leftTopValue, Math.min(leftValue, topValue)) + 1;
                }
                // DP[i][j], max 중 최대값 저장
                max = Math.max(max, DP[i][j]);
            }
        }
        System.out.println(max * max);
    }
}
