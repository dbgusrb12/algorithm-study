package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Scanner;

public class P1328_빌딩 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 빌딩 개수
        int N = sc.nextInt();
        // 왼쪽에서 본 빌딩 수
        int L = sc.nextInt();
        // 오른쪽에서 본 빌딩 수
        int R = sc.nextInt();
        long[][][] DP = new long[101][101][101];
        DP[1][1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    // 가장 작은 빌딩을 가운데에 놓는 경우
                    long middleCase = DP[i - 1][j][k] * (i - 2);
                    // 가장 작은 빌딩을 오른쪽에 넣는 경우
                    long rightCase = DP[i - 1][j][k - 1];
                    // 가장 작은 빌딩을 왼쪽에 놓는 경우
                    long leftCase = DP[i - 1][j - 1][k];
                    DP[i][j][k] = (middleCase + rightCase + leftCase) % 1000000007;
                }
            }
        }
        System.out.println(DP[N][L][R]);
    }
}
