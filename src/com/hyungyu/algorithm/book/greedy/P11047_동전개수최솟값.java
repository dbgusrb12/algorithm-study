package com.hyungyu.algorithm.book.greedy;

import java.io.IOException;
import java.util.Scanner;

public class P11047_동전개수최솟값 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coinArray = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            coinArray[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N; i > 0; i--) {
            if (coinArray[i] <= K) {
                count += (K / coinArray[i]);
                K %= coinArray[i];
                if (K == 0) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
