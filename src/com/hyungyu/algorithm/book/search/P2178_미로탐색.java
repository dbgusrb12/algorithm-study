package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    public static boolean[][] visitFlagArray;
    public static int N;
    public static int M;
    public static int[][] maze;
    // 상하좌우 비교용 배열
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visitFlagArray = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String numString = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(numString.substring(j, j + 1));
            }
        }
        breadthFirstSearch(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    public static void breadthFirstSearch(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            visitFlagArray[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (isValid(nextX, nextY)) {
                    visitFlagArray[nextX][nextY] = true;
                    // 인접리스트 depth 증가
                    maze[nextX][nextY] = maze[currentX][currentY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        // index 유효성 검사
        if (x >= N || y >= M || x < 0 || y < 0) {
            return false;
        }
        // 이동 할 수 있는 노드인지, 방문 했던 노드인지
        if (maze[x][y] <= 0 || visitFlagArray[x][y]) {
            return false;
        }
        return true;
    }
}
