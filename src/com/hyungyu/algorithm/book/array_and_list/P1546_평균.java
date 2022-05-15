package com.hyungyu.algorithm.book.array_and_list;

import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] testScores = new int[N];
        for (int i = 0; i < N; i++) {
            testScores[i] = sc.nextInt();
        }
        // sum 은 구해지는 값이 정수형이기 때문에 int 로 선언
        int sum = 0;
        int max = 0;
        int length = testScores.length;
        for (int i = 0; i < length; i++) {
            if (max < testScores[i]) {
                max = testScores[i];
            }
            sum += testScores[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
