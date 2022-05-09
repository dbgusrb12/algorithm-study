package com.hyungyu.algorithm.book._3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] nArray = new int[N + 1][N + 1];
        for (int x = 1; x <= N; x++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int y = 1; y <= N; y++) {
                nArray[x][y] = Integer.parseInt(stringTokenizer.nextToken()) + nArray[x][y - 1] + nArray[x - 1][y] - nArray[x - 1][y - 1];
//                nArray[x][y] = nArray[x][y - 1] + Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int sum = nArray[x2][y2] - nArray[x2][y1 - 1] - nArray[x1 - 1][y2] + nArray[x1 - 1][y1 - 1];
            System.out.println(sum);
//            for (int j = x1; j <= x2; j++) {
//                sum += nArray[j][y2] - nArray[j][y1 - 1];
//            }
//            System.out.println(sum);
        }
    }
}
