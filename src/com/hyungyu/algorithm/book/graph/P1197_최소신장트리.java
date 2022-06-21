package com.hyungyu.algorithm.book.graph;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1197_최소신장트리 {
    static int[] parent;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        queue = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            queue.add(new Edge(start, end, weight));
        }
        int useEdge = 0;
        int result = 0;
        while (useEdge < N - 1) {
            Edge current = queue.poll();
            int start = current.getStart();
            int end = current.getEnd();
            if (isDiffSet(start, end)) {
                union(start, end);
                result += current.getWeight();
                useEdge++;
            }
        }
        System.out.println(result);
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

    public static boolean isDiffSet(int node, int targetNode) {
        return find(node) != find(targetNode);
    }

    public static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.getWeight();
        }
    }
}
