package com.hyungyu.algorithm.book.greedy;

import java.util.Scanner;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        String[] plusStr = formula.split("-");
        int plusLength = plusStr.length;
        int answer = 0;
        for (int i = 0; i < plusLength; i++) {
            int temp = mySum(plusStr[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }

    public static int mySum(String num) {
        int sum = 0;
        String[] temp = num.split("[+]");
        int tempLength = temp.length;
        for (int i = 0; i < tempLength; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
