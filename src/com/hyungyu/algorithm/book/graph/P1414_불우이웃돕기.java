package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414_불우이웃돕기 {
    static int[] parent;
    static int N;
    static int sum;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tempCharacters = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                int temp = 0;
                if (tempCharacters[j] >= 'a' && tempCharacters[j] <= 'z') {
                    // a ~ z = 1 ~ 26
                    temp = tempCharacters[j] - 'a' + 1;
                } else if (tempCharacters[j] >= 'A' && tempCharacters[j] <= 'Z') {
                    // A ~ Z = 27 ~ 52
                    temp = tempCharacters[j] - 'A' + 27;
                }
                sum += temp;
                if (i != j && temp != 0) {
                    queue.add(new Edge(i, j, temp));
                }
            }
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int start = current.getStart();
            int end = current.getEnd();
            if (isDiffSet(start, end)) {
                union(start, end);
                result += current.getWeight();
                useEdge++;
            }
        }
        if (useEdge == N - 1) {
            System.out.println(sum - result);
        } else {
            System.out.println(-1);
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
