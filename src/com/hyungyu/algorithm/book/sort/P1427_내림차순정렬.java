package com.hyungyu.algorithm.book.sort;

import java.io.IOException;
import java.util.Scanner;

public class P1427_내림차순정렬 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String numString = sc.next();
        int N = numString.length();
        char[] numStringToCharArray = numString.toCharArray();
        int[] numArray = new int[N];
        for (int i = 0; i < N; i++) {
            numArray[i] = numStringToCharArray[i] - '0';
        }
        for (int i = 0; i < N; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (numArray[j] > numArray[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (numArray[i] < numArray[maxIndex]) {
                int temp = numArray[i];
                numArray[i] = numArray[maxIndex];
                numArray[maxIndex] = temp;
            }
            stringBuilder.append(numArray[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
