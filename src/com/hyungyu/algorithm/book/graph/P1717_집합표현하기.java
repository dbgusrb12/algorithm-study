package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_집합표현하기 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());
            if (question == 0) {
                union(node, targetNode);
            } else {
                if (isSameSet(node, targetNode)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node != targetNode) {
            parent[targetNode] = node;
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static boolean isSameSet(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node == targetNode) {
            return true;
        }
        return false;
    }
}
