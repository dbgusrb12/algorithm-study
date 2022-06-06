package com.hyungyu.algorithm.book.number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11689_GCDNK1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer = N;
        double sqrt = Math.sqrt(N);
        for (long i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                answer -= answer / i;
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        if (N > 1) {
            answer -= answer / N;
        }
        System.out.println(answer);
    }
}
