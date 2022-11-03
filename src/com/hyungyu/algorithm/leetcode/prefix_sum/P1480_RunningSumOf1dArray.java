package com.hyungyu.algorithm.leetcode.prefix_sum;

public class P1480_RunningSumOf1dArray {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 10, 1};
        int[] answer = runningSum(nums);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] sumArray = new int[length];
        sumArray[0] = nums[0];
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            sumArray[i] = sumArray[i - 1] + num;
        }
        return sumArray;
    }
}
