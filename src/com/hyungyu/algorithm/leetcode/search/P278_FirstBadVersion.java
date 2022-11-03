package com.hyungyu.algorithm.leetcode.search;

public class P278_FirstBadVersion {

    static int bad = 4;

    public static void main(String[] args) {
        int n = 5;
        int answer = firstBadVersion(n);
        System.out.println(answer);
    }

    public static int firstBadVersion(int n) {
        int startIndex = 1;
        int endIndex = n;
        while (startIndex < endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (isBadVersion(middleIndex)) {
                endIndex = middleIndex;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return startIndex;
    }

    public static boolean isBadVersion(int version) {
        return version >= bad;
    }
}
