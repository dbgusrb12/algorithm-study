package com.hyungyu.algorithm.book.number_theory;

import java.util.Scanner;

public class P1747_소수팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numArray = new int[10000001];
        int length = numArray.length;
        for (int i = 2; i < length; i++) {
            numArray[i] = i;
        }
        double sqrt = Math.sqrt(length);
        for (int i = 2; i < sqrt; i++) {
            if (numArray[i] == 0) {
                continue;
            }
            for (int j = i + i; j < length; j += i) {
                numArray[j] = 0;
            }
        }
        int i = N;
        while (true) {
            if (numArray[i] != 0) {
                int result = numArray[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    public static boolean isPalindrome(int target) {
        char temp[] = String.valueOf(target).toCharArray();
        int startIndex = 0;
        int endIndex = temp.length - 1;
        while (startIndex < endIndex) {
            if (temp[startIndex] != temp[endIndex]) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
