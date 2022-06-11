package com.hyungyu.algorithm.book.number_theory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850_최대공약수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long A = sc.nextLong();
        long B = sc.nextLong();
        long result = gcd(A, B);
        while (result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        System.out.println();
        bw.close();
    }

    public static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
