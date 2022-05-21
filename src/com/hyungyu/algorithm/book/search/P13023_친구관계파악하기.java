package com.hyungyu.algorithm.book.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_친구관계파악하기 {
    public static ArrayList<Integer>[] adjacencyList;
    public static boolean[] visitFlagArray;
    public static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N];
        visitFlagArray = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int targetPerson = Integer.parseInt(st.nextToken());
            adjacencyList[person].add(targetPerson);
            adjacencyList[targetPerson].add(person);
        }

        for (int i = 0; i < N; i++) {
            depthFirstSearch(i, 1);
        }
        if (answer) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void depthFirstSearch(int visitIndex, int depth) {
        if (depth > 4 || answer) {
            answer = true;
            return;
        }
        visitFlagArray[visitIndex] = true;
        ArrayList<Integer> visitList = adjacencyList[visitIndex];
        for (Integer visit : visitList) {
            if (!visitFlagArray[visit]) {
                depthFirstSearch(visit, depth + 1);
            }
        }
        visitFlagArray[visitIndex] = false;
    }
}
