package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1167_트리의지름 {
    public static boolean[] visitFlagArray;
    public static int[] distanceArray;
    public static ArrayList<Edge>[] adjacencyList;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int targetNode = Integer.parseInt(st.nextToken());
                if (targetNode == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                adjacencyList[node].add(new Edge(targetNode, distance));
            }
        }
        visitFlagArray = new boolean[N + 1];
        distanceArray = new int[N + 1];
        breadthFirstSearch(1);
        int maxIndex = getMaxDistanceIndex();
        visitFlagArray = new boolean[N + 1];
        distanceArray = new int[N + 1];
        breadthFirstSearch(maxIndex);
        maxIndex = getMaxDistanceIndex();
        System.out.println(distanceArray[maxIndex]);
    }

    public static void breadthFirstSearch(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visitFlagArray[startNode] = true;
        while (!queue.isEmpty()) {
            Integer nodeIndex = queue.poll();
            ArrayList<Edge> edges = adjacencyList[nodeIndex];
            for (Edge edge : edges) {
                int targetNode = edge.getTargetNode();
                int distance = edge.getDistance();
                if (!visitFlagArray[targetNode]) {
                    visitFlagArray[targetNode] = true;
                    distanceArray[targetNode] = distanceArray[nodeIndex] + distance;
                    queue.add(targetNode);
                }
            }
        }
    }

    public static int getMaxDistanceIndex() {
        int maxIndex = 1;
        for (int i = 2; i <= N; i++) {
            if (distanceArray[maxIndex] < distanceArray[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static class Edge {
        private int targetNode;
        private int distance;

        public Edge(int targetNode, int distance) {
            this.targetNode = targetNode;
            this.distance = distance;
        }

        public int getTargetNode() {
            return targetNode;
        }

        public int getDistance() {
            return distance;
        }
    }
}
