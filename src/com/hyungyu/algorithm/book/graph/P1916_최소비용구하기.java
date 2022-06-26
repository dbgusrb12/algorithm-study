package com.hyungyu.algorithm.book.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용구하기 {
    static int N, M;
    static ArrayList<Node>[] adjacencyList;
    static int[] distance;
    static boolean[] visitArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visitArray = new boolean[N + 1];
        distance = new int[N + 1];
        // 거리 배열 큰 수로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        adjacencyList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjacencyList[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.getTargetNode();
            if (visitArray[current]) {
                continue;
            }
            visitArray[current] = true;
            for (Node next : adjacencyList[current]) {
                int nextTarget = next.getTargetNode();
                if (!visitArray[nextTarget] && distance[nextTarget] > distance[current] + next.getValue()) {
                    distance[nextTarget] = distance[current] + next.getValue();
                    queue.add(new Node(nextTarget, distance[nextTarget]));
                }
            }
        }
        return distance[end];
    }

    public static class Node implements Comparable<Node> {

        private int targetNode;
        private int value;

        public Node(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }

        public int getTargetNode() {
            return targetNode;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.getValue();
        }
    }
}
