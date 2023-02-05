package com.hyungyu.algorithm.leetcode.two_pointer;

public class P27_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println(k);
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }
}
