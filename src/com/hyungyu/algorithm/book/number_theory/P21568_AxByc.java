package com.hyungyu.algorithm.book.number_theory;

import java.io.*;
import java.util.StringTokenizer;

public class P21568_AxByc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long gcd = gcd(A, B);
        if (C % gcd != 0) {
            System.out.println(-1);
        } else {
            int quotient = (int) (C / gcd);
            long [] ret = execute(A, B);
            bw.write(ret[0] * quotient + " " + ret[1] * quotient);
            bw.flush();
            System.out.println();
            bw.close();
        }
    }
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
    public static long[] execute(long a, long b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = execute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }
}
