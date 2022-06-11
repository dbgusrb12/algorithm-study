package com.hyungyu.algorithm.book.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325_효율적인해킹 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visitArray;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 컴퓨터 개수
        int N = Integer.parseInt(st.nextToken());
        // 신뢰 관계 개수
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjacencyList[start].add(end);
        }
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visitArray = new boolean[N + 1];
            breadthFirstSearch(i);
        }
        int maxValue = 0;
        for (int i = 1; i <= N; i++) {
            int visitCount = answer[i];
            if (visitCount > maxValue) {
                maxValue = visitCount;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxValue) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void breadthFirstSearch(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        visitArray[startNode] = true;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer targetNode : adjacencyList[node]) {
                if (!visitArray[targetNode]) {
                    visitArray[targetNode] = true;
                    answer[targetNode]++;
                    queue.add(targetNode);
                }
            }
        }
    }
}
