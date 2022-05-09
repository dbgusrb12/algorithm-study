package com.hyungyu.algorithm.book._3_5;

import java.util.Scanner;

public class P10986_나머지합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N + 1];
        int[] C = new int[M];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int remainder = S[i] % M;
            if (remainder == 0) {
                answer++;
            }

            C[remainder]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}
