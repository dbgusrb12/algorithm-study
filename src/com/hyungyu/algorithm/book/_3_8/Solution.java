package com.hyungyu.algorithm.book._3_8;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] C = new long[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextLong();
        }

        Arrays.sort(C);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int start_index = 0;
            int end_index = N - 1;
            long K = C[i];

            while(start_index < end_index) {
                long sum = C[start_index] + C[end_index];
                if (sum < K) {
                    start_index++;
                } else if (sum > K) {
                    end_index--;
                } else {
                    if (start_index != i && end_index != i) {
                        count++;
                        break;
                    } else if (start_index == i) {
                        start_index++;
                    } else if (end_index == i) {
                        end_index--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
