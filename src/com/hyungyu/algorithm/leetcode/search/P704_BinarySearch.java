package com.hyungyu.algorithm.leetcode.search;

public class P704_BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int answer = search(nums, target);
        System.out.println(answer);
    }

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int answer = -1;

        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            int num = nums[middleIndex];
            if (num > target) {
                endIndex = middleIndex - 1;
            } else if (num < target) {
                startIndex = middleIndex + 1;
            } else {
                answer = middleIndex;
                break;
            }
        }
        return answer;
    }
}
