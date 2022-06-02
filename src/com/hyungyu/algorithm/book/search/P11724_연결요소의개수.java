package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    public static ArrayList<Integer>[] adjacencyList;
    public static boolean[] visitFlagArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N + 1];
        visitFlagArray = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            // 양방향 엣지이므로 target 에도 추가를 해야한다.
            adjacencyList[node].add(target);
            adjacencyList[target].add(node);
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visitFlagArray[i]) {
                answer++;
                depthFirstSearch(i);
            }
        }
        System.out.println(answer);
    }

    public static void depthFirstSearch(int visitIndex) {
        if (visitFlagArray[visitIndex]) {
            return;
        }
        visitFlagArray[visitIndex] = true;
        ArrayList<Integer> visitList = adjacencyList[visitIndex];
        for (Integer visit : visitList) {
            if (!visitFlagArray[visit]) {
                depthFirstSearch(visit);
            }
        }
    }

}
