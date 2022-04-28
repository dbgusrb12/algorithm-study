package com.hyungyu.algorithm.data_structures.array;

public interface Array {

    /**
     * 숫자의 합 구하기
     *
     * @param N    : 숫자의 개수 (1 <= N <= 100)
     * @param sNum : N개의 숫자를 나열한 값
     * @return N개 숫자의 합
     */
    int sum(int N, String sNum);

    /**
     * 평균 구하기
     * N개 과목 중 최대값을 구해 점수 / 최대값 * 100 한 점수들의 평균
     *
     * @param N          : 과목의 개수 (1 <= N <= 1000)
     * @param testScores : N개 과목의 점수들
     * @return 점수 / 과목의 최대 값 * 100 을 한 점수들의 평균
     */
    double average(int N, int[] testScores);
}
