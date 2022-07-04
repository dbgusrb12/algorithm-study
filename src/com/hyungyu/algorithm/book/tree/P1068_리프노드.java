package com.hyungyu.algorithm.book.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068_리프노드 {
    // 방문 배열
    static boolean[] visitArray;
    // 인접 리스트(트리)
    static ArrayList<Integer>[] adjacencyList;
    // 삭제할 노드
    static int deleteNode;
    // 리프 노드 개수
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드 개수
        int N = sc.nextInt();
        // 방문 배열 초기화
        visitArray = new boolean[N];
        // 인접 리스트 초기화
        adjacencyList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                // 부모 노드 일 경우 DFS 첫 탐색을 위해 저장
                root = i;
            } else {
                adjacencyList[i].add(parent);
                adjacencyList[parent].add(i);
            }
        }
        // 삭제할 노드
        deleteNode = sc.nextInt();
        if (deleteNode == root) {
            // 삭제 노드가 루트 노드 일 때 리프 노드는 0
            System.out.println(0);
        } else {
            // DFS 탐색 후 결과 출력
            depthFirstSearch(root);
            System.out.println(result);
        }
    }

    public static void depthFirstSearch(int node) {
        visitArray[node] = true;
        int childCount = 0;
        for (int child : adjacencyList[node]) {
            // 방문 했거나, 삭제 노드일 경우 제외
            if (visitArray[child] || child == deleteNode) {
                continue;
            }
            visitArray[child] = true;
            childCount++;
            depthFirstSearch(child);
        }
        // 자식 노드가 없다면 리프 노드 이기 때문에 결과 ++
        if (childCount == 0) {
            result++;
        }
    }
}
