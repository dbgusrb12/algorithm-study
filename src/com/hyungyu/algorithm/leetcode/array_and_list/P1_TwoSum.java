package com.hyungyu.algorithm.leetcode.array_and_list;

import java.util.HashMap;

public class P1_TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] answer = twoSum(nums, target);
        for (int index : answer) {
            System.out.println(index);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pairIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (pairIndexMap.containsKey(left)) {
                return new int[]{pairIndexMap.get(left), i};
            }
            pairIndexMap.put(nums[i], i);
        }
        return new int[2];
    }
}
