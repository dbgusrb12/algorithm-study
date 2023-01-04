package com.hyungyu.algorithm.leetcode.sort;

public class P26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int beforeNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (beforeNum != nums[i]) {
                nums[index++] = nums[i];
            }
            beforeNum = nums[i];
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }
}
