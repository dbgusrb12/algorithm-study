package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516_게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 건물 개수
        int N = Integer.parseInt(br.readLine());
        // 인접 리스트 선언 및 초기화
        ArrayList<Integer>[] adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        // 진입 차수 배열
        int[] inDegree = new int[N + 1];
        // 건물 건설 시간 배열 선언 및 초기화
        int[] buildTime = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물 건설 시간 데이터 저장
            buildTime[i] = Integer.parseInt(st.nextToken());
            // 인접 리스트 데이터 저장
            while (true) {
                int buildingId = Integer.parseInt(st.nextToken());
                if (buildingId == -1) {
                    break;
                }
                adjacencyList[buildingId].add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[N + 1];
        // 위상 정렬 실행
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next : adjacencyList[current]) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[current] + buildTime[current]);
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}
