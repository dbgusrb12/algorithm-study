package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS와BFS {
    public static ArrayList<Integer>[] adjacencyList;
    public static boolean[] visitFlagArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N + 1];
        visitFlagArray = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            adjacencyList[node].add(target);
            adjacencyList[target].add(node);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjacencyList[i]);
        }
        depthFirstSearch(start);
        System.out.println();
        visitFlagArray = new boolean[N + 1];
        breadthFirstSearch(start);
        System.out.println();
    }

    public static void depthFirstSearch(int visitIndex) {
        if (visitFlagArray[visitIndex]) {
            return;
        }
        System.out.print(visitIndex + " ");
        visitFlagArray[visitIndex] = true;
        ArrayList<Integer> visitList = adjacencyList[visitIndex];
        for (Integer visitNode : visitList) {
            if (!visitFlagArray[visitNode]) {
                depthFirstSearch(visitNode);
            }
        }
    }

    public static void breadthFirstSearch(int visitIndex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(visitIndex);
        visitFlagArray[visitIndex] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.print(node + " ");
            ArrayList<Integer> visitList = adjacencyList[node];
            for (Integer visit : visitList) {
                if (!visitFlagArray[visit]) {
                    visitFlagArray[visit] = true;
                    queue.add(visit);
                }
            }
        }
    }
}
