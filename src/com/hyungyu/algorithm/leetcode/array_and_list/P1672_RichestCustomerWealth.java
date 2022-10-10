package com.hyungyu.algorithm.leetcode.array_and_list;

public class P1672_RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        int answer = maximumWealth(accounts);
        System.out.println(answer);
    }

    public static int maximumWealth(int[][] accounts) {
        int answer = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
