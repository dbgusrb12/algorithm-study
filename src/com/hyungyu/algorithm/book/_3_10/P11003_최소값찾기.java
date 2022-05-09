package com.hyungyu.algorithm.book._3_10;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최소값찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> myDeque = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());

            while (!myDeque.isEmpty() && myDeque.getLast().getValue() > target) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(i, target));

            if (myDeque.getFirst().getIndex() < i - L + 1) {
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().getValue() + " ");
        }

        bw.flush();
        bf.close();
        bw.close();
    }

    public static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
