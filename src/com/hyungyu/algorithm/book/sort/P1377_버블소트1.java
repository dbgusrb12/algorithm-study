package com.hyungyu.algorithm.book.sort;

import java.util.Arrays;
import java.util.Scanner;

public class P1377_버블소트1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ComparableOriginIndex[] originArray = new ComparableOriginIndex[N];
        for (int i = 0; i < N; i++) {
            originArray[i] = new ComparableOriginIndex(sc.nextInt(), i);
        }
        Arrays.sort(originArray);
        int maxCompareIndex = 0;
        for (int i = 0; i < N; i++) {
            int originIndex = originArray[i].getIndex();
            if (i < originIndex) {
                maxCompareIndex = originIndex - i;
            }
        }
        System.out.println(maxCompareIndex + 1);
    }

    public static class ComparableOriginIndex implements Comparable<ComparableOriginIndex> {

        private int value;
        private int index;

        public ComparableOriginIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(ComparableOriginIndex o) {
            return this.value - o.getValue();
        }
    }
}
