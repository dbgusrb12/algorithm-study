package com.hyungyu.algorithm.book.sort;

import java.util.Scanner;

public class P2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = sc.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(origin[i]);
        }
    }
}
