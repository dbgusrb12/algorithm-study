package com.hyungyu.algorithm.book.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int firstStudent = sc.nextInt();
            int secondStudent = sc.nextInt();
            adjacencyList[firstStudent].add(secondStudent);
            inDegree[secondStudent]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int currentStudent = queue.poll();
            System.out.println(currentStudent + " ");
            for (Integer nextStudent : adjacencyList[currentStudent]) {
                inDegree[nextStudent]--;
                if (inDegree[nextStudent] == 0) {
                    queue.offer(nextStudent);
                }
            }
        }
    }
}
