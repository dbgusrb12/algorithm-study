package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로 {
    static int V, E, K;
    static int[] distance;
    static boolean[] visitArray;
    static ArrayList<Edge>[] adjacencyList;
    static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        visitArray = new boolean[V + 1];
        adjacencyList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjacencyList[u].add(new Edge(v, w));
        }
        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentVertex = current.getVertex();
            if (visitArray[currentVertex]) {
                continue;
            }
            visitArray[currentVertex] = true;
            int currentSize = adjacencyList[currentVertex].size();
            for (int i = 0; i < currentSize; i++) {
                Edge temp = adjacencyList[currentVertex].get(i);
                int next = temp.getVertex();
                int value = temp.getValue();
                if (distance[next] > distance[currentVertex] + value) {
                    distance[next] = value + distance[currentVertex];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visitArray[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        private int vertex;
        private int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        public int getVertex() {
            return vertex;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.value > o.getValue()) {
                return 1;
            }
            return -1;
        }
    }
}
