package com.hyungyu.algorithm.leetcode.search;

public class P35_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int answer = searchInsert(nums, target);
        System.out.println(answer);
    }

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int answer = 0;

        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            int num = nums[middleIndex];
            if (num > target) {
                // middle index 의 수가 target 보다 클 경우 해당 index 에 들어가야함
                answer = middleIndex;
                endIndex = middleIndex - 1;
            } else if (num < target) {
                // middle index 의 수가 target 보다 작을 경우 이후에 들어가야함
                startIndex = middleIndex + 1;
                answer = startIndex;
            } else {
                answer = middleIndex;
                break;
            }
        }
        return answer;
    }
}
