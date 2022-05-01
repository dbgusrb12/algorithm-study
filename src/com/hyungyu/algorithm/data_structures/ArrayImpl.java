package com.hyungyu.algorithm.data_structures;

public class ArrayImpl implements Array {
    @Override
    public int sum(int N, String sNum) {
        if (sNum == null) {
            throw new IllegalArgumentException("sNum is not null");
        }
        if (sNum.length() != N) {
            throw new IllegalArgumentException("The length of sNum must be equal to N.");
        }
        char[] chars = sNum.toCharArray();
        // 반복문 돌 때 배열에 계속 접근하기 보다 변수에 할당해서 쓰는게 좋음.
        int length = chars.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += chars[i] - '0';
            // 이렇게도 쓸 수 있다.
            // sum += Character.getNumericValue(chars[i]);
        }
        return sum;
    }

    @Override
    public double average(int N, int[] testScores) {
        if (testScores == null) {
            throw new IllegalArgumentException("testScores is not null");
        }
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive number.");
        }
        if (testScores.length != N) {
            throw new IllegalArgumentException("The length of testScores must be equal to N.");
        }

        // sum 은 구해지는 값이 정수형이기 때문에 int 로 선언
        int sum = 0;
        int max = 0;
        for (int i = 0; i < testScores.length; i++) {
            if (max < testScores[i]) {
                max = testScores[i];
            }
            sum += testScores[i];
        }

        // TODO testScores 의 모든 값이 0 일 경우는?
        return sum * 100.0 / max / N;
    }
}
