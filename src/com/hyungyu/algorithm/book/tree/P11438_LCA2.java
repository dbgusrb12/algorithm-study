package com.hyungyu.algorithm.book.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11438_LCA2 {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kMaxValue;
    static int[][] parent;
    static boolean[] visitArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 수
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }
        depth = new int[N + 1];
        visitArray = new boolean[N + 1];
        int temp = 1;
        kMaxValue = 0;
        while (temp <= N) {
            temp *= 2;
            kMaxValue++;
        }
        parent = new int[kMaxValue + 1][N + 1];
        breadthFirstSearch(1);
        for (int k = 1; k <= kMaxValue; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = executeLCA(a, b);
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
                parent[0][next] = current;
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

    public static int executeLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kMaxValue; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a] && depth[a] <= depth[parent[k][b]]) {
                b = parent[k][b];
            }
        }
        for (int k = kMaxValue; k >= 0 && a != b; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a != b ? parent[0][a] : a;
        return LCA;
    }

}
