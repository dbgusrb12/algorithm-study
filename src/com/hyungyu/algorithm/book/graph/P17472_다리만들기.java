package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17472_다리만들기 {
    // 상하좌우 비교용 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 부모 노드 배열
    static int[] parent;
    // 자동 정렬을 위한 우선순위 큐
    static PriorityQueue<Edge> queue;
    // 지도 세로 크기
    static int N;
    // 지도 가로 크기
    static int M;
    // 지도 정보
    static int[][] map;
    // 방문 배열
    static boolean[][] visitArray;
    // 모든 섬 정보
    static ArrayList<ArrayList<int[]>> islandList;
    // 특정 섬 정보
    static ArrayList<int[]> island;
    // 섬 번호
    static int islandNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 지도 세로 크기
        N = Integer.parseInt(st.nextToken());
        // 지도 가로 크기
        M = Integer.parseInt(st.nextToken());
        // 방문 배열 초기화
        visitArray = new boolean[N][M];
        // 지도 크기 할당
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        islandNum = 1;
        islandList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visitArray[i][j]) {
                    // 지도의 섬을 기준으로 방문하지 않은 섬 BFS 탐색 (섬 분리)
                    breadthFirstSearch(i, j);
                    islandNum++;
                    islandList.add(island);
                }
            }
        }
        queue = new PriorityQueue<>();
        // 섬의 각 지점에서 만들 수 있는 모든 에지 저장
        for (ArrayList<int[]> current : islandList) {
            int currentSize = current.size();
            for (int i = 0; i < currentSize; i++) {
                int x = current.get(i)[0];
                int y = current.get(i)[1];
                int currentStart = map[x][y];
                // 상하좌우 네 방향 검색
                for (int d = 0; d < 4; d++) {
                    int tempX = dx[d];
                    int tempY = dy[d];
                    int weight = 0;
                    while (x + tempX >= 0 && x + tempX < N && y + tempY >= 0 && y + tempY < M) {
                        // 탐색 할 x, y 좌표 추출
                        int moveX = x + tempX;
                        int moveY = y + tempY;
                        // 해당 좌표의 값 추출
                        int targetCoordinate = map[moveX][moveY];
                        if (targetCoordinate == currentStart) {
                            // 같은 섬인지 체크 (같은 섬이면 에지를 만들 수 없다.)
                            break;
                        }
                        if (targetCoordinate != 0) {
                            // 다른 섬인지 체크 (같은 섬이 아니고 바다가 아니면 다른 섬)
                            if (weight > 1) {
                                // 다른 섬과의 길이가 1 이상일 때 에지로 더함
                                queue.add(new Edge(currentStart, targetCoordinate, weight));
                            }
                            break;
                        }
                        // 바다면 다리의 길이 연장 후 다음 좌표 설정
                        weight++;
                        if (tempX < 0) {
                            tempX--;
                        } else if (tempX > 0) {
                            tempX++;
                        } else if (tempY < 0) {
                            tempY--;
                        } else if (tempY > 0) {
                            tempY++;
                        }
                    }
                }
            }
        }
        // 섬의 개수 만큼 노드 선언 및 초기화
        parent = new int[islandNum];
        for (int i = 0; i < islandNum; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        // 최소 신장 트리 알고리즘 수행
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int start = current.getStart();
            int end = current.getEnd();
            if (isDiffSet(start, end)) {
                union(start, end);
                result += current.getWeight();
                useEdge++;
            }
        }
        if (useEdge == islandNum - 2) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }

    public static void breadthFirstSearch(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        island = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        island.add(start);
        visitArray[i][j] = true;
        map[i][j] = islandNum;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            // 상하좌우 네 방향 검색
            for (int d = 0; d < 4; d++) {
                int tempX = dx[d];
                int tempY = dy[d];
                while (x + tempX >= 0 && x + tempX < N && y + tempY >= 0 && y + tempY < M) {
                    int moveX = x + tempX;
                    int moveY = y + tempY;
                    if (visitArray[moveX][moveY] || map[moveX][moveY] == 0) {
                        // 방문했거나, 바다라면 종료
                        break;
                    }
                    // 해당 좌표의 해당하는 위치를 섬의 정보로 포함시킨다.
                    addNode(moveX, moveY, queue);
                    if (tempX < 0) {
                        tempX--;
                    } else if (tempX > 0) {
                        tempX++;
                    } else if (tempY < 0) {
                        tempY--;
                    } else if (tempY > 0) {
                        tempY++;
                    }
                }
            }
        }
    }

    public static void addNode(int x, int y, Queue<int[]> queue) {
        map[x][y] = islandNum;
        visitArray[x][y] = true;
        int[] temp = {x, y};
        island.add(temp);
        queue.add(temp);
    }

    public static void union(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node != targetNode) {
            parent[targetNode] = node;
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static boolean isDiffSet(int node, int targetNode) {
        return find(node) != find(targetNode);
    }

    public static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.getWeight();
        }
    }
}
