package com.hyungyu.algorithm.book.two_pointer;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;
        while (endIndex < N) {
            if (sum > N) {
                // 합이 N보다 크다면 범위를 줄여야 한다.
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                // 합이 N보다 작다면 범위를 늘려야 한다.
                endIndex++;
                sum += endIndex;
            } else {
                // 합이 N과 같다면 경우의 수를 늘리고 범위를 늘려야 한다.
                endIndex++;
                sum += endIndex;
                count++;
            }
        }
        System.out.println(count);
    }
}
