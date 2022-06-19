package com.hyungyu.algorithm.book.graph;

import java.util.Scanner;

public class P1976_여행계획짜기 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] country = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                country[i][j] = sc.nextInt();
            }
        }
        int[] routes = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            routes[i] = sc.nextInt();
        }
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (country[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int rootNode = find(routes[1]);
        int length = routes.length;
        for (int i = 2; i < length; i++) {
            if (rootNode != find(routes[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node != targetNode) {
            parent[targetNode] = node;
        }
    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}
