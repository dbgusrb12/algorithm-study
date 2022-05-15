package com.hyungyu.algorithm.book.stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                Integer index = stack.pop();
                answer[index] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            answer[index] = -1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
