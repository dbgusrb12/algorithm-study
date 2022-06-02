package com.hyungyu.algorithm.book.search;

import java.util.Scanner;

public class P2023_신기한소수 {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 2, 3, 5, 7
        depthFirstSearch(2, 1);
        depthFirstSearch(3, 1);
        depthFirstSearch(5, 1);
        depthFirstSearch(7, 1);
    }

    public static void depthFirstSearch(int firstNumber, int digit) {
        if (digit == N) {
            if (isPrime(firstNumber)) {
                System.out.println(firstNumber);
            }
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            int targetNumber = firstNumber * 10 + i;
            if (isPrime(targetNumber)) {
                depthFirstSearch(targetNumber, digit + 1);
            }
        }
    }

    public static boolean isPrime(int number) {
        int max = number / 2;
        for (int i = 2; i < max; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
