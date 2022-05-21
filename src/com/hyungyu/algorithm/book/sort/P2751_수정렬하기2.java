package com.hyungyu.algorithm.book.sort;

import java.util.Scanner;

public class P2751_수정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[] numArray = new int[N + 1];
        int[] tempArray = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numArray[i] = sc.nextInt();
        }
        mergeSort(1, N, numArray, tempArray);
        for (int i = 1; i <= N; i++) {
            sb.append(numArray[i] + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void mergeSort(int startIndex, int endIndex, int[] numArray, int[] tempArray) {
        if (endIndex - startIndex < 1) {
            return;
        }
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        mergeSort(startIndex, middleIndex, numArray, tempArray);
        mergeSort(middleIndex + 1, endIndex, numArray, tempArray);

        for (int i = startIndex; i <= endIndex; i++) {
            tempArray[i] = numArray[i];
        }
        int numArrayIndex = startIndex;
        int leftIndex = startIndex;
        int rightIndex = middleIndex + 1;
        while (leftIndex <= middleIndex && rightIndex <= endIndex) {
            // 양쪽 그룹의 index 가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동한다.
            if (tempArray[leftIndex] > tempArray[rightIndex]) {
                numArray[numArrayIndex] = tempArray[rightIndex];
                numArrayIndex++;
                rightIndex++;
            } else {
                numArray[numArrayIndex] = tempArray[leftIndex];
                numArrayIndex++;
                leftIndex++;
            }
        }

        while (leftIndex <= middleIndex) {
            numArray[numArrayIndex] = tempArray[leftIndex];
            numArrayIndex++;
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            numArray[numArrayIndex] = tempArray[rightIndex];
            numArrayIndex++;
            rightIndex++;
        }
    }
}
