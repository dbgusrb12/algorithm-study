package com.hyungyu.algorithm.book.graph;

import java.util.*;

public class P18352_특정거리도시찾기 {
    static int[] visitArray;
    static ArrayList<Integer>[] adjacencyList;
    static ArrayList<Integer> answer;
    static int N, M, K, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 도시 개수
        N = sc.nextInt();
        // 도로 개수
        M = sc.nextInt();
        // 거리 정보
        K = sc.nextInt();
        // 출발 도시 번호
        X = sc.nextInt();
        answer = new ArrayList<>();
        // 방문 배열 초기화
        visitArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visitArray[i] = -1;
        }
        // 인접 리스트 초기화
        adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adjacencyList[start].add(end);
        }
        breadthFirstSearch(X);

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (Integer result : answer) {
                System.out.println(result);
            }
        }

    }

    public static void breadthFirstSearch(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visitArray[startNode]++;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer targetNode : adjacencyList[node]) {
                if (visitArray[targetNode] < 0) {
                    int visitCount = visitArray[node] + 1;
                    visitArray[targetNode] = visitCount;
                    queue.add(targetNode);
                    if (visitCount == K) {
                        answer.add(targetNode);
                    }
                }
            }
        }
    }
}
