package com.hyungyu.algorithm.leetcode.prefix_sum;

public class P724_FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int answer = pivotIndex(nums);
        System.out.println(answer);
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int partSum = 0;
        int length = nums.length;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < length; i++) {
            if (partSum == sum - partSum - nums[i]) {
                return i;
            }
            partSum += nums[i];
        }
        return -1;
    }
}
