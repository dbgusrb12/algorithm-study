package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class P2342_DDR {

    public static void main(String[] args) {
        // 한 발을 이동 할 떄 드는 힘을 미리 저장 (MP[1][2] = 1에서 2로 이동 할 때 드는 힘)
        int[][] MP = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1},
        };
        // DP[N][L][R] = N개 수열을 수행했고, 왼쪽이 L, 오른쪽이 R 에 있을 때 최소 누적 힘
        int[][][] DP = new int[100001][5][5];
        // DP 배열 충분히 큰수로 초기화
        for (int[][] dpFirstDepth : DP) {
            for (int[] dpSecondDepth : dpFirstDepth) {
                Arrays.fill(dpSecondDepth, 100001 * 4);
            }
        }
        DP[0][0][0] = 0;
        Scanner sc = new Scanner(System.in);
        int N = 0;
        int count = 1;
        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                // 입력 종료
                break;
            }
            // 오른발 위치 계산
            for (int i = 0; i < 5; i++) {
                if (N == i) {
                    // 두 발이 같은 지점에 존재 하면 안됨
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    // 이전 위치의 최소 누적 힘
                    int previous = DP[count - 1][i][j];
                    // j 에서 N으로 이동할 때 드는 힘
                    int movePoint = MP[j][N];
                    // 현재 위치 최소 누적 힘
                    int current = DP[count][i][N];
                    // 오른발을 옮겨 현재 모습이 됐을 때 최소 힘 저장
                    DP[count][i][N] = Math.min(previous + movePoint, current);
                }
            }
            // 왼발 위치 계산
            for (int i = 0; i < 5; i++) {
                if (N == i) {
                    // 두 발이 같은 지점에 존재 하면 안됨
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    // 이전 위치의 최소 누적 힘
                    int previous = DP[count - 1][j][i];
                    // j 에서 N으로 이동할 때 드는 힘
                    int movePoint = MP[j][N];
                    // 현재 위치 최소 누적 힘
                    int current = DP[count][N][i];
                    // 왼발을 옮겨 현재 모습이 됐을 때 최소 힘 저장
                    DP[count][N][i] = Math.min(previous + movePoint, current);
                }
            }
            count++;
        }
        count--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, DP[count][i][j]);
            }
        }
        System.out.println(min);
    }

}
