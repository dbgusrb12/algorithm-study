package com.hyungyu.algorithm.book.sort;

import java.util.Scanner;

public class P11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] withdrawalTimeArray = new int[N];
        int[] sumArray = new int[N];
        for (int i = 0; i < N; i++) {
            withdrawalTimeArray[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int insertPoint = i;
            int insertValue = withdrawalTimeArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (withdrawalTimeArray[j] < insertValue) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPoint = 0;
                }
            }
            for (int j = i; j > insertPoint; j--) {
                withdrawalTimeArray[j] = withdrawalTimeArray[j - 1];
            }
            withdrawalTimeArray[insertPoint] = insertValue;
        }
        sumArray[0] = withdrawalTimeArray[0];
        int sum = sumArray[0];
        for (int i = 1; i < N; i++) {
            sumArray[i] = sumArray[i - 1] + withdrawalTimeArray[i];
            sum += sumArray[i];
        }
        System.out.println(sum);
    }
}
