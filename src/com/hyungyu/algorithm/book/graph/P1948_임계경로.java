package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948_임계경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 도시의 개수
        int N = Integer.parseInt(br.readLine());
        // 도로의 개수
        int M = Integer.parseInt(br.readLine());
        // 인접 리스트, 역방향 인접 리스트 선언 및 초기화
        ArrayList<Node>[] adjacencyList = new ArrayList[N + 1];
        ArrayList<Node>[] reverseAdjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
            reverseAdjacencyList[i] = new ArrayList<>();
        }
        // 진입 차수 배열 선언 및 초기화
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 출발 도시
            int city = Integer.parseInt(st.nextToken());
            // 도착 도시
            int targetCity = Integer.parseInt(st.nextToken());
            // 걸리는 시간
            int arrivalTime = Integer.parseInt(st.nextToken());
            // 인접 리스트 데이터 저장
            adjacencyList[city].add(new Node(targetCity, arrivalTime));
            // 역방향 인접 리스트 데이터 저장
            reverseAdjacencyList[targetCity].add(new Node(city, arrivalTime));
            // 진입 차수 배열 초기 데이터 저장
            inDegree[targetCity]++;
        }
        st = new StringTokenizer(br.readLine());
        // 시작 도시
        int startCity = Integer.parseInt(st.nextToken());
        // 도착 도시
        int endCity = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCity);
        int[] result = new int[N + 1];
        // 위상 정렬 실행
        while (!queue.isEmpty()) {
            Integer currentCity = queue.poll();
            for (Node nextCity : adjacencyList[currentCity]) {
                inDegree[nextCity.getTargetNode()]--;
                result[nextCity.getTargetNode()] = Math.max(result[nextCity.getTargetNode()], result[currentCity] + nextCity.getArrivalTime());
                if (inDegree[nextCity.getTargetNode()] == 0) {
                    queue.add(nextCity.getTargetNode());
                }
            }
        }

        int resultCount = 0;
        boolean[] visitArray = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.add(endCity);
        visitArray[endCity] = true;
        // 위상 정렬 reverse 실행
        while (!queue.isEmpty()) {
            Integer currentCity = queue.poll();
            for (Node nextCity : reverseAdjacencyList[currentCity]) {
                if (result[nextCity.getTargetNode()] + nextCity.getArrivalTime() != result[currentCity]) {
                    continue;
                }
                resultCount++;
                if (visitArray[nextCity.getTargetNode()]) {
                    continue;
                }
                visitArray[nextCity.getTargetNode()] = true;
                queue.add(nextCity.getTargetNode());
            }
        }
        System.out.println(result[endCity]);
        System.out.println(resultCount);
    }

    public static class Node {
        int targetNode;
        int arrivalTime;

        public Node(int targetNode, int arrivalTime) {
            this.targetNode = targetNode;
            this.arrivalTime = arrivalTime;
        }

        public int getTargetNode() {
            return targetNode;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }
    }
}
