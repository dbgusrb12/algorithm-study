package com.hyungyu.algorithm.book._3_6;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        int count = 1;
        while(end_index < N) {
            if (sum > N) {
                // 합이 N보다 크다면 범위를 줄여야 한다.
                sum -= start_index;
                start_index++;
            } else if (sum < N) {
                // 합이 N보다 작다면 범위를 늘려야 한다.
                end_index++;
                sum += end_index;
            } else {
                // 합이 N과 같다면 경우의 수를 늘리고 범위를 늘려야 한다.
                end_index++;
                sum += end_index;
                count++;
            }
        }
        System.out.println(count);
    }
}
