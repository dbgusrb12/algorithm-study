package com.hyungyu.algorithm.book.number_theory;

import java.util.Scanner;

public class P1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] numArray = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            numArray[i] = i;
        }
        double sqrt = Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (numArray[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                numArray[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if (numArray[i] != 0) {
                System.out.println(numArray[i]);
            }
        }
    }
}
