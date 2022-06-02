package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArray);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int targetNum = Integer.parseInt(st.nextToken());
            int startIndex = 0;
            int endIndex = N - 1;
            while (startIndex <= endIndex) {
                int middleIndex = (startIndex + endIndex) / 2;
                if (numArray[middleIndex] > targetNum) {
                    endIndex = middleIndex - 1;
                } else if (numArray[middleIndex] < targetNum) {
                    startIndex = middleIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
