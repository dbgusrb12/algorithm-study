package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visitArray;
    static int[] nodeGroup;
    static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            visitArray = new boolean[nodeCount + 1];
            nodeGroup = new int[nodeCount + 1];
            isBipartiteGraph = true;
            adjacencyList = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine());
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                adjacencyList[startNode].add(endNode);
                adjacencyList[endNode].add(startNode);
            }

            for (int i = 1; i < nodeCount; i++) {
                if (!isBipartiteGraph) {
                    break;
                }
                depthFirstSearch(i);
            }
            if (isBipartiteGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void depthFirstSearch(int node) {
        visitArray[node] = true;
        for (Integer targetNode : adjacencyList[node]) {
            if (!visitArray[targetNode]) {
                nodeGroup[targetNode] = (nodeGroup[node] + 1) % 2;
                depthFirstSearch(targetNode);
            } else if (nodeGroup[node] == nodeGroup[targetNode]) {
                isBipartiteGraph = false;
            }
        }
    }
}
