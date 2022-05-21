package com.hyungyu.algorithm.book.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numArray = new int[N];
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(numArray, 0, N - 1, K - 1);
        System.out.println(numArray[K - 1]);

    }

    public static void quickSort(int[] numArray, int startIndex, int endIndex, int K) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = compareTo(numArray, startIndex, endIndex);
        if (pivot == K) {
            return;
        }
        if (K < pivot) {
            quickSort(numArray, startIndex, pivot - 1, K);
            return;
        }
        quickSort(numArray, pivot + 1, endIndex, K);
    }

    public static int compareTo(int[] numArray, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex) / 2;
        swap(numArray, startIndex, middleIndex);
        int pivot = numArray[startIndex];
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            while (pivot < numArray[j]) {
                j--;
            }
            while (i < j && pivot >= numArray[i]) {
                i++;
            }
            swap(numArray, i, j);
        }
        numArray[startIndex] = numArray[i];
        numArray[i] = pivot;
        return i;
    }

    public static void swap(int[] numArray, int swap1, int swap2) {
        int temp = numArray[swap1];
        numArray[swap1] = numArray[swap2];
        numArray[swap2] = temp;
    }
}
