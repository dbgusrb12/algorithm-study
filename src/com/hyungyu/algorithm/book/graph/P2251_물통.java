package com.hyungyu.algorithm.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251_물통 {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visitArray = new boolean[201][201];
    static int[] current = new int[3];
    static boolean[] result = new boolean[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        current[0] = Integer.parseInt(st.nextToken());
        current[1] = Integer.parseInt(st.nextToken());
        current[2] = Integer.parseInt(st.nextToken());
        breadthFirstSearch();
        int length = result.length;
        for (int i = 0; i < length; i++) {
            if (result[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void breadthFirstSearch() {
        Queue<Ab> queue = new LinkedList<>();
        queue.add(new Ab(0, 0));
        visitArray[0][0] = true;
        int initialC = current[2];
        result[initialC] = true;
        while (!queue.isEmpty()) {
            Ab target = queue.poll();
            int a = target.getA();
            int b = target.getB();
            int c = initialC - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                int receiveIndex = receiver[i];
                int sendIndex = sender[i];
                next[receiveIndex] += next[sendIndex];
                next[sendIndex] = 0;
                if (next[receiveIndex] > current[receiveIndex]) {
                    next[sendIndex] = next[receiveIndex] - current[receiveIndex];
                    next[receiveIndex] = current[receiveIndex];
                }
                if (!visitArray[next[0]][next[1]]) {
                    visitArray[next[0]][next[1]] = true;
                    queue.add(new Ab(next[0], next[1]));
                    if (next[0] == 0) {
                        result[next[2]] = true;
                    }
                }
            }
        }
    }

    public static class Ab {
        private int a;
        private int b;

        public Ab(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
