package com.hyungyu.algorithm.book.sort;

import java.util.Scanner;

public class P10989_수정렬하기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] numArray = new int[N];
        for (int i = 0; i < N; i++) {
            numArray[i] = sc.nextInt();
        }
        radixSort(numArray, 5);
        for (int i = 0; i < N; i++) {
            sb.append(numArray[i] + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void radixSort(int[] numArray, int maxDigit) {
        int length = numArray.length;
        int[] tempArray = new int[length];
        int digit = 1;
        int count = 0;
        while (count < maxDigit) { // 최대 자릿수까지 반복한다.
            int[] bucket = new int[10];
            for (int i = 0; i < length; i++) {
                bucket[(numArray[i] / digit) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (int i = length - 1; i >= 0; i--) {
                int bucketIndex = numArray[i] / digit % 10;
                int tempArrayIndex = bucket[bucketIndex] - 1;
                tempArray[tempArrayIndex] = numArray[i];
                bucket[bucketIndex]--;
            }
            for (int i = 0; i < length; i++) {
                numArray[i] = tempArray[i];
            }
            digit *= 10;
            count++;
        }
    }
}
