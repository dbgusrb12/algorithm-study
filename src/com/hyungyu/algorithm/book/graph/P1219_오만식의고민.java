package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219_오만식의고민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        long[] cityMoney = new long[N];
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[startCity] = cityMoney[startCity];
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                int start = edge.getStart();
                int end = edge.getEnd();
                int price = edge.getPrice();
                if (distance[start] == Long.MIN_VALUE) {
                    continue;
                }
                if (distance[start] == Long.MAX_VALUE) {
                    distance[end] = Long.MAX_VALUE;
                    continue;
                }
                long morePrice = distance[start] + cityMoney[end] - price;
                if (distance[end] >= morePrice) {
                    continue;
                }
                distance[end] = morePrice;
                if (i >= N - 1) {
                    distance[end] = Long.MAX_VALUE;
                }
            }
        }
        if (distance[endCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (distance[endCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(distance[endCity]);
        }
    }

    public static class Edge {
        private int start;
        private int end;
        private int price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPrice() {
            return price;
        }
    }
}
