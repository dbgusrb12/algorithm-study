package com.hyungyu.algorithm.book.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class P11049_행렬곱연산횟수의최솟값 {

    static int N;
    static Matrix[] M;
    static int[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 행렬 개수
        N = sc.nextInt();
        // 행렬 정보 저장 배열
        M = new Matrix[N + 1];
        // DP 배열 선언 및 초기화
        DP = new int[N + 1][N + 1];
        for (int[] dpFirstDepth : DP) {
            Arrays.fill(dpFirstDepth, -1);
        }
        // 행렬 정보 선언 및 초기화
        for (int i = 1; i <= N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(x, y);
        }
        System.out.println(execute(1, N));

    }

    /**
     * 점화식: DP[startIndex][endIndex] = startIndex ~ endIndex 구간을 합치는 데 드는 최소 연산 횟수
     *
     * @param startIndex : 시작 인덱스
     * @param endIndex   : 종료 인덱스
     * @return
     */
    public static int execute(int startIndex, int endIndex) {
        if (DP[startIndex][endIndex] != -1) {
            // 이미 계산을 했다면 다시 계산하지 않음
            return DP[startIndex][endIndex];
        }
        if (startIndex == endIndex) {
            // 행렬 1개의 곱셈 연산의 수
            return 0;
        }
        Matrix startMatrix = M[startIndex];
        Matrix endMatrix = M[endIndex];
        if (startIndex + 1 == endIndex) {
            // 행렬 2개의 곱셈 연산의 수
            return startMatrix.getY() * startMatrix.getX() * endMatrix.getX();
        }
        int result = Integer.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            Matrix matrix = M[i];
            // 첫번째 행렬
            int firstMatrix = execute(startIndex, i);
            // 두번째 행렬
            int secondMatrix = execute(i + 1, endIndex);
            // 두 행렬을 합치는데 드는 값
            int a = startMatrix.getY() * matrix.getX() * endMatrix.getX();
            // result 와 위의 세 값을 더한 값 중 최솟값 추출
            result = Math.min(result, a + firstMatrix + secondMatrix);
        }
        return DP[startIndex][endIndex] = result;
    }

    public static class Matrix {

        private int x;
        private int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
