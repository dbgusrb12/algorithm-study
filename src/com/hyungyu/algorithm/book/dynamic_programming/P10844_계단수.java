package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Scanner;

public class P10844_계단수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] D = new long[N + 1][11];
        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                D[i][j] = mod(D[i - 1][j - 1], D[i - 1][j + 1]);
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = mod(sum, D[N][i]);
        }
        System.out.println(sum);
    }

    public static long mod(long num1, long num2) {
        return (num1 + num2) % 1000000000;
    }
}
