package com.hyungyu.algorithm.book.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868_최솟값 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수의 개수
        int N = Integer.parseInt(st.nextToken());
        // 구간의 최솟값을 구하는 횟수
        int M = Integer.parseInt(st.nextToken());
        int length = N;
        // 트리의 높이 선언 및 초기화
        int treeHeight = 0;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        // 트리 사이즈 선언
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        // 리프 노드 시작 인덱스 추출
        int leafNodeStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];
        int treeLength = tree.length;
        for (int i = 0; i < treeLength; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = leafNodeStartIndex + 1; i <= leafNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        // 초기 트리 세팅
        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start += leafNodeStartIndex;
            end += leafNodeStartIndex;
            System.out.println(getMin(start, end));
        }
    }

    /**
     * 초기 트리 구성 세팅
     *
     * @param index : 트리 배열 마지막 인덱스 - 1(마지막 이전의 리프 노드 인덱스)
     */
    public static void setTree(int index) {
        while (index != 1) {
            tree[index / 2] = Math.min(tree[index / 2], tree[index]);
            index--;
        }
    }

    /**
     * 최솟값 구하기
     *
     * @param startIndex : 시작 index
     * @param endIndex   : 끝 index
     * @return 최솟값
     */
    public static long getMin(int startIndex, int endIndex) {
        long min = Long.MAX_VALUE;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                min = Math.min(min, tree[startIndex]);
                startIndex++;
            }
            if (endIndex % 2 == 0) {
                min = Math.min(min, tree[endIndex]);
                endIndex--;
            }
            startIndex /= 2;
            endIndex /= 2;
        }
        return min;
    }
}
