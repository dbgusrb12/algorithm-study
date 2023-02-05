package com.hyungyu.algorithm.leetcode.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class P70_ClimbingStairs {

    public static void main(String[] args) {
        int n = 45;
        int answer = climbStairs(n);
        System.out.println(answer);
    }

    public static int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);

        return inToStep(n, memo);
    }

    private static int inToStep(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, inToStep(n - 1, memo) + inToStep(n - 2, memo));
        return memo.get(n);
    }
}
