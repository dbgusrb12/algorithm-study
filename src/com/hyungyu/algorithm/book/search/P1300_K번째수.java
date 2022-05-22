package com.hyungyu.algorithm.book.search;

import java.util.Scanner;

public class P1300_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        long startIndex = 1;
        long endIndex = k;
        long answer = 0;
        while (startIndex <= endIndex) {
            long middleIndex = (startIndex + endIndex) / 2;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                long smallCount = middleIndex / i;
                count += smallCount > N ? N : smallCount;
            }
            if (count < k) {
                startIndex = middleIndex + 1;
            } else {
                answer = middleIndex;
                endIndex = middleIndex - 1;
            }
        }
        System.out.println(answer);
    }
}
