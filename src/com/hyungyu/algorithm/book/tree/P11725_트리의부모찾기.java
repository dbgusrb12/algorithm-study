package com.hyungyu.algorithm.book.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725_트리의부모찾기 {
    // 노드의 개수
    static int N;
    // 방문 배열
    static boolean[] visitArray;
    // 인접 리스트(트리)
    static ArrayList<Integer>[] adjacencyList;
    // 결과 배열
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드의 개수
        N = sc.nextInt();
        // 방문 배열 선언 및 초기화
        visitArray = new boolean[N + 1];
        // 결과 배열 선언 및 초기화
        result = new int[N + 1];
        // 인접 리스트(트리) 선언 및 초기화
        adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();
            adjacencyList[firstNode].add(secondNode);
            adjacencyList[secondNode].add(firstNode);
        }
        // DFS 실행
        depthFirstSearch(1);

        // 결과 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    public static void depthFirstSearch(int node) {
        visitArray[node] = true;
        for (Integer child : adjacencyList[node]) {
            if (!visitArray[child]) {
                result[child] = node;
                depthFirstSearch(child);
            }
        }
    }
}
