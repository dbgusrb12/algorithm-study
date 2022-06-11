package com.hyungyu.algorithm.book.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> cardBundle = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int card = sc.nextInt();
            cardBundle.add(card);
        }
        int total = 0;

        while (cardBundle.size() > 1) {
            Integer firstBundle = cardBundle.remove();
            Integer secondBundle = cardBundle.remove();
            int sum = firstBundle + secondBundle;
            total += sum;
            cardBundle.add(sum);
        }

        System.out.println(total);
    }
}
