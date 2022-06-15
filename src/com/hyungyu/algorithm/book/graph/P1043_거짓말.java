package com.hyungyu.algorithm.book.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class P1043_거짓말 {
    static int[] parent;
    static int[] truePerson;
    static ArrayList<Integer>[] party;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        truePerson = new int[T];
        for (int i = 0; i < T; i++) {
            truePerson[i] = sc.nextInt();
        }
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            int partyMemberCount = sc.nextInt();
            for (int j = 0; j < partyMemberCount; j++) {
                party[i].add(sc.nextInt());
            }
        }
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            int partyMemberCount = party[i].size();
            for (int j = 1; j < partyMemberCount; j++) {
                union(firstPeople, party[i].get(j));
            }
        }
        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int currentParty = party[i].get(0);
            int trustPeopleCount = truePerson.length;
            for (int j = 0; j < trustPeopleCount; j++) {
                if (isSameSet(currentParty, truePerson[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void union(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node != targetNode) {
            parent[targetNode] = node;
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static boolean isSameSet(int node, int targetNode) {
        node = find(node);
        targetNode = find(targetNode);
        if (node == targetNode) {
            return true;
        }
        return false;
    }
}
