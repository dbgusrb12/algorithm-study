package com.hyungyu.algorithm.book.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[node][0] = left == '.' ? -1 : left - 'A';
            tree[node][1] = right == '.' ? -1 : right - 'A';
        }
        // 전위 순회
        preOrder(0);
        System.out.println();
        // 중위 순회
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    public static void preOrder(int current) {
        if (current == -1) {
            return;
        }
        char currentChar = (char) (current + 'A');
        System.out.print(currentChar);
        preOrder(tree[current][0]); // 왼쪽 노드 탐색
        preOrder(tree[current][1]); // 오른쪽 노드 탐색
    }

    public static void inOrder(int current) {
        if (current == -1) {
            return;
        }
        char currentChar = (char) (current + 'A');
        inOrder(tree[current][0]);
        System.out.print(currentChar);
        inOrder(tree[current][1]);
    }

    public static void postOrder(int current) {
        if (current == -1) {
            return;
        }
        char currentChar = (char) (current + 'A');
        postOrder(tree[current][0]);
        postOrder(tree[current][1]);
        System.out.print(currentChar);
    }
}
