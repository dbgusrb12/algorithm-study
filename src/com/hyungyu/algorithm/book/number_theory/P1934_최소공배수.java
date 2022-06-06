package com.hyungyu.algorithm.book.number_theory;

import java.util.Scanner;

public class P1934_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int result = A * B / gcd(A, B);
            System.out.println(result);
        }
    }

    public static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
