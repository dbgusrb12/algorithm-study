package com.hyungyu.algorithm.book._3_3;

import java.util.Scanner;

public class P11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            sumArray[i] = sumArray[i - 1] + num;
        }
        for (int k = 1; k <= M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int answer = sumArray[j] - sumArray[i - 1];
            System.out.println(answer);
        }
    }
}
