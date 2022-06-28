package com.hyungyu.algorithm.book.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505_구간곱구하기 {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수의 개수
        int N = Integer.parseInt(st.nextToken());
        // 변경이 일어나는 횟수
        int M = Integer.parseInt(st.nextToken());
        // 구간 곱을 구하는 횟수
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafNodeStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        int treeLength = tree.length;
        for (int i = 0; i < treeLength; i++) {
            // 곱셈이므로 초깃값을 1로 설정
            tree[i] = 1;
        }
        for (int i = leafNodeStartIndex + 1; i <= leafNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int startIndex = Integer.parseInt(st.nextToken());
            long endValue = Long.parseLong(st.nextToken());
            if (a == 1) {
                changeValue(leafNodeStartIndex + startIndex, endValue);
                continue;
            }

            if (a == 2) {
                startIndex += leafNodeStartIndex;
                endValue += leafNodeStartIndex;
                System.out.println(getMultiple(startIndex, (int) endValue));
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
            tree[index / 2] = mod(tree[index / 2], tree[index]);
            index--;
        }
    }

    /**
     * index 번째 수를 customValue 로 변경
     *
     * @param index       : 변경 할 index
     * @param customValue : 변경 할 수
     */
    public static void changeValue(int index, long customValue) {
        tree[index] = customValue;
        while (index > 1) {
            index /= 2;
            tree[index] = mod(tree[index * 2]) * mod(tree[index * 2 + 1]);
        }
    }

    /**
     * 구간 곱 구하기
     *
     * @param startIndex : 시작 index
     * @param endIndex   : 끝 index
     * @return 구간 곱
     */
    public static long getMultiple(int startIndex, int endIndex) {
        long multiple = 1;

        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                multiple = mod(multiple, tree[startIndex]);
                startIndex++;
            }
            if (endIndex % 2 == 0) {
                multiple = mod(multiple, tree[endIndex]);
                endIndex--;
            }
            startIndex /= 2;
            endIndex /= 2;
        }
        return multiple;
    }

    /**
     * 1000000007 로 나눈 나머지 계산
     *
     * @param value : 나머지 연산 할 value
     * @return 나머지
     */
    public static long mod(long value) {
        return value % 1000000007;
    }

    /**
     * 1000000007 로 나눈 나머지 계산
     * (A * B) % C = (A % C) * (B % C) % C
     *
     * @param value1 : 나머지 연산 할 value 1
     * @param value2 : 나머지 연산 할 value 2
     * @return 나머지
     */
    public static long mod(long value1, long value2) {
        return (value1 % 1000000007) * (value2 % 1000000007) % 1000000007;
    }
}
