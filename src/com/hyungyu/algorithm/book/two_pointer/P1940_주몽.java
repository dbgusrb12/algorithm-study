package com.hyungyu.algorithm.book.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class P1940_주몽 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }
        Arrays.sort(C);
        int start_index = 0;
        int end_index = N - 1;
        int sum = 0;
        int count = 0;
        while (start_index < end_index) {
            sum = C[start_index] + C[end_index];
            if (sum > M) {
                end_index--;
            } else if (sum < M) {
                start_index++;
            } else {
                count++;
                start_index++;
                end_index--;
            }
        }
        System.out.println(count);
    }
}
