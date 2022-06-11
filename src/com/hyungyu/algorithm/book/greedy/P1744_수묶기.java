package com.hyungyu.algorithm.book.greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> positiveNum = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>();

        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                positiveNum.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                negativeNum.add(num);
            }
        }
        int sum = 0;

        while (positiveNum.size() > 1) {
            int first = positiveNum.remove();
            int second = positiveNum.remove();
            sum += first * second;
        }
        if (!positiveNum.isEmpty()) {
            sum += positiveNum.remove();
        }
        while (negativeNum.size() > 1) {
            int first = negativeNum.remove();
            int second = negativeNum.remove();
            sum += first * second;
        }
        if (!negativeNum.isEmpty()) {
            if (zero == 0) {
                sum += negativeNum.remove();
            }
        }
        sum += one;
        System.out.println(sum);
    }
}
