package com.hyungyu.algorithm.book.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11437_LCA {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visitArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드의 수
        int N = sc.nextInt();
        // 트리 선언 및 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            tree[start].add(end);
            tree[end].add(start);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visitArray = new boolean[N + 1];
        // BFS 로 depth 구하기
        breadthFirstSearch(1);
        // 질의의 수
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = executeLca(a, b);
            System.out.println(LCA);
        }
    }

    public static void breadthFirstSearch(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visitArray[node] = true;
        int level = 1;
        int currentSize = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer next : tree[current]) {
                if (visitArray[next]) {
                    continue;
                }
                visitArray[next] = true;
                queue.add(next);
                parent[next] = current;
                depth[next] = level;
            }
            count++;
            if (count == currentSize) {
                count = 0;
                currentSize = queue.size();
                level++;
            }
        }
    }

    public static int executeLca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

}
