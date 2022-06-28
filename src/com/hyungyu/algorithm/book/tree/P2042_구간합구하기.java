package com.hyungyu.algorithm.book.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_구간합구하기 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수의 개수
        int N = Integer.parseInt(st.nextToken());
        // 수의 변경이 일어나는 횟수
        int M = Integer.parseInt(st.nextToken());
        // 구간의 합을 구하는 횟수
        int K = Integer.parseInt(st.nextToken());
        // 트리의 높이, 수의 개수 선언 및 초기화
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        // 트리 사이즈 선언
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        // 리프 노드 시작 인덱스 추출
        int leafNodeStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        // 리프 노드 세팅
        for (int i = leafNodeStartIndex + 1; i <= leafNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        // 초기 트리 세팅
        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            // 1 = start 번째 수를 end 로 변경, 2 = start 번째 수 부터 end 번째 수 까지의 구간 합
            long a = Integer.parseInt(st.nextToken());
            int startIndex = Integer.parseInt(st.nextToken());
            long endValue = Long.parseLong(st.nextToken());
            if (a == 1) {
                // start 번째 수를 end 로 변경
                changeValue(leafNodeStartIndex + startIndex, endValue);
                continue;
            }
            if (a == 2) {
                // start 번째 수 부터 end 번째 수 까지의 구간 합
                startIndex += leafNodeStartIndex;
                endValue += leafNodeStartIndex;
                System.out.println(getSum(startIndex, (int) endValue));
                continue;
            }
            break;
        }
    }

    /**
     * 초기 트리 구성 세팅
     *
     * @param index : 트리 배열 마지막 인덱스 - 1(마지막 이전의 리프 노드 인덱스)
     */
    public static void setTree(int index) {
        while (index != 1) {
            tree[index / 2] += tree[index];
            index--;
        }
    }

    public static void changeValue(int index, long customValue) {
        long diff = customValue - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }
    }

    public static long getSum(int startIndex, int endIndex) {
        long sum = 0;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                sum += tree[startIndex];
                startIndex++;
            }
            if (endIndex % 2 == 0) {
                sum += tree[endIndex];
                endIndex--;
            }
            startIndex /= 2;
            endIndex /= 2;
        }

        return sum;
    }

}
