package com.hyungyu.algorithm.book.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14003_가장길게증가하는부분수열 {

    static int N;
    static int maxLength;
    static int[] B = new int[1000001];
    static int[] A = new int[1000001];
    static int[] D = new int[1000001];
    static int[] answer = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        B[++maxLength] = A[1];
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (B[maxLength] < A[i]) {
                // 가장 마지막 수열보다 현재 수열이 클 때
                B[++maxLength] = A[i];
                D[i] = maxLength;
            } else {
                // B 배열에서 A[i] 보다 처음으로 크거나 같아지는 원소의 index 찾기
                index = binarySearch(1, maxLength, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }
        // 가장 길고, 증가하는 부분의 수열 길이 출력
        System.out.println(maxLength);
        index = maxLength;
        int x = B[maxLength] + 1;
        for (int i = N; i >= 1; i--) {
            // 뒤에서부터 탐색하면서 정답 수열 저장
            if (D[i] == index && A[i] < x) {
                answer[index] = A[i];
                x = A[i];
                index--;
            }
        }
        for (int i = 1; i <= maxLength; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    /**
     * 현재 수열이 들어갈 수 있는 위치를 빠르게 찾기 위한 바이너리 서치
     *
     * @param left  : left index
     * @param right : right index
     * @param now   : 현재 수열
     * @return
     */
    public static int binarySearch(int left, int right, int now) {
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (B[middle] < now) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

}
