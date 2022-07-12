package com.hyungyu.algorithm.book.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9252_LCS {

    static long[][] DP;
    static ArrayList<Character> path;
    static char[] firstStr;
    static char[] secondStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        firstStr = br.readLine().toCharArray();
        secondStr = br.readLine().toCharArray();
        int firstLength = firstStr.length;
        int secondLength = secondStr.length;
        DP = new long[firstLength + 1][secondLength + 1];
        path = new ArrayList<>();
        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                if (firstStr[i - 1] == secondStr[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[firstLength][secondLength]);
        getText(firstLength, secondLength);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    public static void getText(int firstLength, int secondLength) {
        if (firstLength == 0 || secondLength == 0) {
            return;
        }
        if (firstStr[firstLength - 1] == secondStr[secondLength - 1]) {
            // 같다면 LCS 에 기록 후 왼쪽 위로 이동
            path.add(firstStr[firstLength - 1]);
            getText(firstLength - 1, secondLength - 1);
            return;
        }

        if (DP[firstLength - 1][secondLength] > DP[firstLength][secondLength - 1]) {
            // 왼쪽이 더 크다면 왼쪽으로 이동
            getText(firstLength - 1, secondLength);
            return;
        }

        // 위쪽이 더 크다면 위쪽으로 이동
        getText(firstLength, secondLength - 1);
    }
}
