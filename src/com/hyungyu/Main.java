package com.hyungyu;

import com.hyungyu.algorithm.data_structures.array.Array;
import com.hyungyu.algorithm.data_structures.array.ArrayImpl;
import com.hyungyu.algorithm.data_structures.prefix_sum.PrefixSum;

public class Main {

    public static void main(String[] args) {
//        Array array = new ArrayImpl();
//
//        System.out.println(array.sum(11, "10987654321"));
//        System.out.println(array.average(2, new int[]{3, 10}));

        PrefixSum prefixSum = new PrefixSum();

        prefixSum.prefixSum();
    }
}
