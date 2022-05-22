package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_블루레이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] playTimeArray = new int[N];

        int maxPlayTime = 0;
        int sumPlayTime = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int currentPlayTime = Integer.parseInt(st.nextToken());
            playTimeArray[i] = currentPlayTime;
            if (maxPlayTime < currentPlayTime) {
                maxPlayTime = currentPlayTime;
            }
            sumPlayTime += currentPlayTime;
        }

        while (maxPlayTime <= sumPlayTime) {
            int middleTime = (maxPlayTime + sumPlayTime) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + playTimeArray[i] > middleTime) {
                    sum = 0;
                    count++;
                }
                sum += playTimeArray[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > M) {
                maxPlayTime = middleTime + 1;
            } else {
                sumPlayTime = middleTime - 1;
            }
        }
        System.out.println(maxPlayTime);
    }
}
