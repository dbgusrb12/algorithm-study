package com.hyungyu.algorithm.book.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2098_외판원순회 {

    static final int INF = 1000000 * 16 + 1;
    static int N;
    static int[][] W;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // W 배열 선언 및 초기화
        // W[i][j] = i 도시에서 j 도시로 가는 데 드는 비용
        W = new int[16][16];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // DP[c][v] = 현재 도시 c, 현재까지 방문한 모든 도시 리스트가 v 일 때 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용
        DP = new int[16][1 << 16];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 1 << N; j++) {
                DP[i][j] = INF;
            }
        }
        System.out.println(tsp(0, 1));

    }

    /**
     * 점화식: traveling salesman problem DP[currentCity][v] = 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용
     *
     * @param currentCity : 현재 도시
     * @param visit           : 현재까지 방문한 모든 도시 리스트 (이진수로 표현)
     * @return
     */
    public static int tsp(int currentCity, int visit) {
        if (visit == (1 << N) - 1) {
            // 모든 노드를 방문할 때
            return W[currentCity][0] == 0 ? INF : W[currentCity][0];
        }
        if (DP[currentCity][visit] != INF) {
            // 이미 방문한 노드일 때는 바로 리턴 (메모이제이션)
            return DP[currentCity][visit];
        }
        int result = INF;
        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) != 0 || W[currentCity][i] == 0) {
                // 방문한 적이 있거나, 갈 수 없는 도시면 패스
                continue;
            }
            // 남은 도시 방문 최소 비용
            int visitCity = tsp(i, (visit | (1 << i)));
            // 해당 도시를 방문하는데 드는 비용
            int visitCost = W[currentCity][i];

            // 현재 도시 부터 남은 도시를 경유하는 데 필요한 최소 비용, 남은 도시 방문 최소 비용 + 해당 도시 방문 비용 중 최솟값 저장
            result = Math.min(result, visitCity + visitCost);
        }
        return DP[currentCity][visit] = result;
    }

}
