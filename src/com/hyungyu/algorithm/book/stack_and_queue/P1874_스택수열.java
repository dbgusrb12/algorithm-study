package com.hyungyu.algorithm.book.stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int current = A[i];
            if (current >= num) {
                while (current >= num) {
                    stack.push(num);
                    num++;
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int pop = stack.pop();
                if (pop > current) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf.toString());
        }
    }
}
