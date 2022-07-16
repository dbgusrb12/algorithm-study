package com.hyungyu.algorithm.book.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13398_연속합2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[N];
        left[0] = A[0];
        int result = left[0];
        for (int i = 1; i < N; i++) {
            left[i] = Math.max(A[i], left[i - 1] + A[i]);
            result = Math.max(result, left[i]);
        }

        int[] right = new int[N];
        right[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = Math.max(A[i], right[i + 1] + A[i]);
        }
        for (int i = 1; i < N - 1; i++) {
            int temp = left[i - 1] + right[i + 1];
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }

}
