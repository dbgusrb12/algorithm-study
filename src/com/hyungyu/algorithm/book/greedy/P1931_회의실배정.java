package com.hyungyu.algorithm.book.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931_회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] meetingArray = new int[N][2];
        for (int i = 0; i < N; i++) {
            meetingArray[i][0] = sc.nextInt();
            meetingArray[i][1] = sc.nextInt();
        }
        Arrays.sort(meetingArray, (startTime, endTime) -> {
            if (startTime[1] == endTime[1]) {
                return startTime[0] - endTime[0];
            }
            return startTime[1] - endTime[1];
        });
        int answer = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (meetingArray[i][0] >= end) {
                end = meetingArray[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
