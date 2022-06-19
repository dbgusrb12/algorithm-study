package com.hyungyu.algorithm.book.graph;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854_K번째최단경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] adjacencyMatrix = new int[1001][1001];
        PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[N + 1];
        Comparator<Integer> comparator = (o1, o2) -> o1 < o2 ? 1 : -1;
        for (int i = 0; i <= N; i++) {
            distanceQueue[i] = new PriorityQueue<>(K, comparator);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjacencyMatrix[startCity][endCity] = weight;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        distanceQueue[1].add(0);
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (adjacencyMatrix[current.getNode()][i] == 0) {
                    continue;
                }
                int adjacencyCost = current.getCost() + adjacencyMatrix[current.getNode()][i];
                if (distanceQueue[i].size() < K) {
                    distanceQueue[i].add(adjacencyCost);
                    queue.add(new Node(i, adjacencyCost));
                } else if (distanceQueue[i].peek() > adjacencyCost) {
                    distanceQueue[i].poll();
                    distanceQueue[i].add(adjacencyCost);
                    queue.add(new Node(i, adjacencyCost));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (distanceQueue[i].size() == K) {
                bw.write(distanceQueue[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node> {
        private int node;
        private int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int getNode() {
            return node;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.getCost() ? -1 : 1;
        }
    }
}
