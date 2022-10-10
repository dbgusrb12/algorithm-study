package com.hyungyu.algorithm.leetcode.number_theory;

import java.util.ArrayList;
import java.util.List;

public class P412_FizzBuzz {

    public static void main(String[] args) {
        int n = 15;
        List<String> strings = fizzBuzz(n);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
