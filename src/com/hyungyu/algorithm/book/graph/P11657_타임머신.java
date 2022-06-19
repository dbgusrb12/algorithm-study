package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Edge[] edges = new Edge[M + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.getStart()] == Integer.MAX_VALUE) {
                    continue;
                }
                long updateValue = distance[edge.getStart()] + edge.getTime();
                if (distance[edge.getEnd()] > updateValue) {
                    distance[edge.getEnd()] = updateValue;
                }
            }
        }
        boolean cycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.getStart()] == Integer.MAX_VALUE) {
                continue;
            }
            long updateValue = distance[edge.getStart()] + edge.getTime();
            if (distance[edge.getEnd()] > updateValue) {
                cycle = true;
                break;
            }
        }
        if (cycle) {
            System.out.println("-1");

        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    public static class Edge {
        private int start;
        private int end;
        private int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getTime() {
            return time;
        }
    }
}
