package com.hyungyu.algorithm.book._3_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    int[] checkPwd = new int[4];
    int[] myPwd = new int[4];
    int check = 0;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
//        char[] dna = new char[S];

        st = new StringTokenizer(br.readLine());
        char[] dna = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkPwd[i] = Integer.parseInt(st.nextToken());
            if (checkPwd[i] == 0) {
                check++;
            }
        }

        int count = 0;
        for (int i = 0; i < P; i++) {
            addMyPwd(dna[i]);
        }
        if (check == 4) {
            count++;
        }

        for (int i = P; i < S; i++) {
            int minus = i - P;
            addMyPwd(dna[i]);
            removeMyPwd(dna[minus]);
            if (check == 4) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }

    private void addMyPwd(char word) {
        switch (word) {
            case 'A':
                myPwd[0]++;
                if (myPwd[0] == checkPwd[0]) {
                    check++;
                }
                break;
            case 'C':
                myPwd[1]++;
                if (myPwd[1] == checkPwd[1]) {
                    check++;
                }
                break;
            case 'G':
                myPwd[2]++;
                if (myPwd[2] == checkPwd[2]) {
                    check++;
                }
                break;
            case 'T':
                myPwd[3]++;
                if (myPwd[3] == checkPwd[3]) {
                    check++;
                }
                break;
        }
    }

    private void removeMyPwd(char word) {
        switch (word) {
            case 'A':
                if (myPwd[0] == checkPwd[0]) {
                    check--;
                }
                myPwd[0]--;
                break;
            case 'C':
                if (myPwd[1] == checkPwd[1]) {
                    check--;
                }
                myPwd[1]--;
                break;
            case 'G':
                if (myPwd[2] == checkPwd[2]) {
                    check--;
                }
                myPwd[2]--;
                break;
            case 'T':
                if (myPwd[3] == checkPwd[3]) {
                    check--;
                }
                myPwd[3]--;
                break;
        }
    }
}
